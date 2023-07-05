package com.aalvarez.hexagonal.adapters.persistence;

import com.aalvarez.hexagonal.adapters.persistence.entities.PostEntity;
import com.aalvarez.hexagonal.adapters.persistence.entities.UserEntity;
import com.aalvarez.hexagonal.adapters.exceptions.NotFoundException;
import com.aalvarez.hexagonal.adapters.persistence.repositories.JpaPostRepository;
import com.aalvarez.hexagonal.adapters.persistence.repositories.JpaUserRepository;
import com.aalvarez.hexagonal.application.ports.out.SavePostPort;
import com.aalvarez.hexagonal.domain.model.Post;
import com.aalvarez.hexagonal.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaPostRepositoryAdapter implements SavePostPort {

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
            throw new NotFoundException("444", "El usuario no existe", "esto es una excepcion custom");
        }

        post.setUser(modelMapper.map(user, User.class));
        
        PostEntity postEntity = modelMapper.map(post, PostEntity.class);
        jpaPostRepository.save(postEntity);
        return post;

    }
}
