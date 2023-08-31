package io.varnonsoft.chat.services;

import io.varnonsoft.chat.entities.Comment;
import io.varnonsoft.chat.repositories.CommentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Mono<Comment> createComment(UUID postId, UUID senderId, String content, Long timestamp) {
        return this.commentRepository.save(doCreateComment(postId, senderId, content, timestamp));
    }

    private Comment doCreateComment(UUID postId, UUID senderId, String content, Long timestamp) {
        return new Comment(UUID.randomUUID(), postId, senderId, content, timestamp);
    }
}
