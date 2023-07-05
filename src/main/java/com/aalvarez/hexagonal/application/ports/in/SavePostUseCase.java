package com.aalvarez.hexagonal.application.ports.in;

import com.aalvarez.hexagonal.domain.model.Post;

public interface SavePostUseCase {

    Post savePost(Post post) throws Exception;

}
