package com.aalvarez.hexagonal.adapters.persistence;

import com.aalvarez.hexagonal.adapters.persistence.entities.PostEntity;
import com.aalvarez.hexagonal.adapters.persistence.entities.UserEntity;
import com.aalvarez.hexagonal.adapters.exceptions.custom.NotFoundException;
import com.aalvarez.hexagonal.adapters.persistence.repositories.JpaPostRepository;
import com.aalvarez.hexagonal.adapters.persistence.repositories.JpaUserRepository;
import com.aalvarez.hexagonal.application.ports.out.GetPostPort;
import com.aalvarez.hexagonal.application.ports.out.SavePostPort;
import com.aalvarez.hexagonal.domain.model.Post;
import com.aalvarez.hexagonal.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaPostRepositoryAdapter implements GetPostPort, SavePostPort {

    @Autowired
    private JpaPostRepository jpaPostRepository;
    @Autowired
    private JpaUserRepository jpaUserRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Post save(Post post){

        Optional<UserEntity> user = jpaUserRepository.findById(post.getUser().getId());
        if(user.isEmpty()){
            throw new NotFoundException("444", "No existe un usuario con id "+post.getUser().getId(), "El mensaje se ha generado con una excepción custom");
        }

        post.setUser(modelMapper.map(user, User.class));
        
        PostEntity postEntity = modelMapper.map(post, PostEntity.class);

        return modelMapper.map(jpaPostRepository.save(postEntity), Post.class);

    }

    @Override
    public List<Post> findAll() {
        return jpaPostRepository.findAll().stream()
                .map(post -> modelMapper.map(post, Post.class))
                .collect(Collectors.toList());
    }
}
