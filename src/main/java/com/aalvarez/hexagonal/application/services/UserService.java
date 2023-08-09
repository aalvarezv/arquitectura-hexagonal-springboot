package com.aalvarez.hexagonal.application.services;

import com.aalvarez.hexagonal.adapters.exceptions.custom.NotFoundException;
import com.aalvarez.hexagonal.adapters.persistence.entities.UserEntity;
import com.aalvarez.hexagonal.adapters.persistence.repositories.JpaUserRepository;
import com.aalvarez.hexagonal.application.ports.in.SaveUserUseCase;
import com.aalvarez.hexagonal.application.ports.out.GetUserPort;
import com.aalvarez.hexagonal.application.ports.out.SaveUserPort;
import com.aalvarez.hexagonal.domain.model.User;
import com.aalvarez.hexagonal.application.ports.in.GetUserUseCase;

import java.util.List;

public class UserService implements GetUserUseCase, SaveUserUseCase {

    private GetUserPort getUserPort;
    private SaveUserPort saveUserPort;

    private JpaUserRepository jpaUserRepository;

    public UserService(GetUserPort getUserPort, SaveUserPort saveUserPort, JpaUserRepository jpaUserRepository) {
        this.getUserPort = getUserPort;
        this.saveUserPort = saveUserPort;
        this.jpaUserRepository = jpaUserRepository;

    }

    @Override
    public User getUserById(Long id) {

        UserEntity optUser = this.jpaUserRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("333", "Usuario id "+id+" no existe", "Comentario adicional"));

        return this.getUserPort.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return this.getUserPort.findAll();
    }

    @Override
    public User save(User user) {
        return this.saveUserPort.save(user);
    }

}
