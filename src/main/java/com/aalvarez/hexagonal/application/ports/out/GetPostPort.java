package com.aalvarez.hexagonal.application.ports.out;

import com.aalvarez.hexagonal.domain.model.Post;

import java.util.List;

public interface GetPostPort {

    List<Post> findAll();

}
