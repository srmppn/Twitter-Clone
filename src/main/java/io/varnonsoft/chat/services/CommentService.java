package io.varnonsoft.chat.services;

import io.varnonsoft.chat.entities.Comment;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CommentService {
    Mono<Comment> createComment(UUID postId, UUID senderId, String content, Long timestamp);
}
