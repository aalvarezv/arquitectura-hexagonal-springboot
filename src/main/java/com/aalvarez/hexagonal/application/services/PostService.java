package com.aalvarez.hexagonal.application.services;

import com.aalvarez.hexagonal.adapters.exceptions.custom.NotFoundException;
import com.aalvarez.hexagonal.adapters.persistence.entities.PostEntity;
import com.aalvarez.hexagonal.adapters.persistence.entities.UserEntity;
import com.aalvarez.hexagonal.adapters.persistence.repositories.JpaPostRepository;
import com.aalvarez.hexagonal.adapters.persistence.repositories.JpaUserRepository;
import com.aalvarez.hexagonal.application.ports.in.GetPostUseCase;
import com.aalvarez.hexagonal.application.ports.in.SavePostUseCase;
import com.aalvarez.hexagonal.application.ports.out.GetPostPort;
import com.aalvarez.hexagonal.application.ports.out.SavePostPort;
import com.aalvarez.hexagonal.domain.model.Post;
import com.aalvarez.hexagonal.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements SavePostUseCase, GetPostUseCase {

    @Autowired
    private SavePostPort savePostPort;
    @Autowired
    private GetPostPort getPostPort;
    @Autowired
    private JpaPostRepository jpaPostRepository;
    @Autowired
    private JpaUserRepository jpaUserRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Post save(Post post) {

        Optional<UserEntity> user = jpaUserRepository.findById(post.getUser().getId());
        if(user.isEmpty()){
            throw new NotFoundException("444", "No existe un usuario con id "+post.getUser().getId(), "El mensaje se ha generado con una excepción custom");
        }

        post.setUser(modelMapper.map(user, User.class));

        return this.savePostPort.save(post);

    }

    @Override
    public List<Post> getAllPost() {
        return this.getPostPort.findAll();
    }

}
