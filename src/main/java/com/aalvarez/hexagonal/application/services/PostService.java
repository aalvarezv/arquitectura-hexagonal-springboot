package com.aalvarez.hexagonal.application.services;

import com.aalvarez.hexagonal.application.ports.in.SavePostUseCase;
import com.aalvarez.hexagonal.application.ports.out.SavePostPort;
import com.aalvarez.hexagonal.domain.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements SavePostUseCase {

    @Autowired
    private SavePostPort savePostPort;

    @Override
    public Post savePost(Post post) {
        return this.savePostPort.save(post);
    }

}
