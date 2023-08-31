package io.varnonsoft.chat.services;

import io.varnonsoft.chat.entities.Post;
import io.varnonsoft.chat.repositories.PostRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Mono<Post> createPost(UUID senderId, String content, Long timestamp) {
        return postRepository.save(doCreatePost(senderId, content, timestamp));
    }

    private Post doCreatePost(UUID senderId, String content, Long timestamp) {
        return new Post(UUID.randomUUID(), senderId, content, timestamp);
    }
}
