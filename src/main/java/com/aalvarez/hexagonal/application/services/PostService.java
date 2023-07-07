package com.aalvarez.hexagonal.application.services;

import com.aalvarez.hexagonal.application.ports.in.GetPostUseCase;
import com.aalvarez.hexagonal.application.ports.in.SavePostUseCase;
import com.aalvarez.hexagonal.application.ports.out.GetPostPort;
import com.aalvarez.hexagonal.application.ports.out.SavePostPort;
import com.aalvarez.hexagonal.domain.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements SavePostUseCase, GetPostUseCase {

    @Autowired
    private SavePostPort savePostPort;
    @Autowired
    private GetPostPort getPostPort;

    @Override
    public Post save(Post post) {
        return this.savePostPort.save(post);
    }

    @Override
    public List<Post> getAllPost() {
        return this.getPostPort.findAll();
    }

}
