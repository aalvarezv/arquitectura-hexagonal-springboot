package com.aalvarez.hexagonal.adapters.persistence;

import com.aalvarez.hexagonal.adapters.exceptions.NotFoundException;
import com.aalvarez.hexagonal.adapters.persistence.repositories.JpaUserRepository;
import com.aalvarez.hexagonal.domain.model.User;
import com.aalvarez.hexagonal.application.ports.out.GetUserPort;
import com.aalvarez.hexagonal.adapters.persistence.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaUserRepositoryAdapter implements GetUserPort {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User findById(Long id) {

       UserEntity optUser = this.jpaUserRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("333", "Usuario id "+id+" no existe", "Comentario adicional"));

       return modelMapper.map(optUser, User.class);

    }

    @Override
    public List<User> findAll() {
        return null;

    }

}
