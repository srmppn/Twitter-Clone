package io.varnonsoft.chat.services;

import io.varnonsoft.chat.entities.Post;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PostService {
    Mono<Post> createPost(UUID senderId, String content, Long timestamp);

}
