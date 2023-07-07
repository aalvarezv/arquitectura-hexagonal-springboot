package com.aalvarez.hexagonal.application.services;

import com.aalvarez.hexagonal.application.ports.in.SaveUserUseCase;
import com.aalvarez.hexagonal.application.ports.out.GetUserPort;
import com.aalvarez.hexagonal.application.ports.out.SaveUserPort;
import com.aalvarez.hexagonal.domain.model.User;
import com.aalvarez.hexagonal.application.ports.in.GetUserUseCase;

import java.util.List;

public class UserService implements GetUserUseCase, SaveUserUseCase {

    private GetUserPort getUserPort;
    private SaveUserPort saveUserPort;

    public UserService(GetUserPort getUserPort, SaveUserPort saveUserPort) {
        this.getUserPort = getUserPort;
        this.saveUserPort = saveUserPort;
    }

    @Override
    public User getUserById(Long id) {
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
