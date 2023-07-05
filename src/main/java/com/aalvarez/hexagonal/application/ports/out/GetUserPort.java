package com.aalvarez.hexagonal.application.ports.out;

import com.aalvarez.hexagonal.domain.model.User;

import java.util.List;

public interface GetUserPort {
    User findById(Long id);
    List<User> findAll();

}
