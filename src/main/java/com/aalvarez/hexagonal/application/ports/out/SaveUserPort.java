package com.aalvarez.hexagonal.application.ports.out;

import com.aalvarez.hexagonal.domain.model.Post;
import com.aalvarez.hexagonal.domain.model.User;

public interface SaveUserPort {

    User save(User user);


}
