package com.aalvarez.hexagonal.application.services;

import com.aalvarez.hexagonal.application.ports.out.GetUserPort;
import com.aalvarez.hexagonal.domain.model.User;
import com.aalvarez.hexagonal.application.ports.in.GetUserUseCase;

import java.util.List;

public class UserService implements GetUserUseCase {

    private final GetUserPort getUserPort;

    public UserService(GetUserPort getUserPort) {
        this.getUserPort = getUserPort;
    }

    @Override
    public User getUserById(Long id) {
        return this.getUserPort.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return this.getUserPort.findAll();
    }

}
