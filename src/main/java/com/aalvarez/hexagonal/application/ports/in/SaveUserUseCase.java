package com.aalvarez.hexagonal.application.ports.in;

import com.aalvarez.hexagonal.domain.model.User;

public interface SaveUserUseCase {

    User save(User user);

}
