package com.aalvarez.hexagonal.application.ports.out;

import com.aalvarez.hexagonal.domain.model.Post;

public interface SavePostPort {

    Post save(Post post);

}
