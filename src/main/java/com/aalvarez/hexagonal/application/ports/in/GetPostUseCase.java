package com.aalvarez.hexagonal.application.ports.in;

import com.aalvarez.hexagonal.domain.model.Post;

import java.util.List;

public interface GetPostUseCase {

    List<Post> getAllPost();

}
