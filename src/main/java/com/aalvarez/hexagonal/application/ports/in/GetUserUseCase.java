package com.aalvarez.hexagonal.application.ports.in;

import com.aalvarez.hexagonal.domain.model.User;
import java.util.Optional;
import java.util.List;

public interface GetUserUseCase {

    User getUserById(Long id);

    List<User> getAllUsers();

}
