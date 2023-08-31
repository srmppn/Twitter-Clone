package io.varnonsoft.chat.repositories;

import io.varnonsoft.chat.entities.Comment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface CommentRepository extends ReactiveCrudRepository<Comment, UUID> {
    Flux<Comment> findByPostId(UUID postId);
}
