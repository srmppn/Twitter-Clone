package io.varnonsoft.chat.services;

import io.varnonsoft.chat.entities.Comment;
import io.varnonsoft.chat.entities.Post;
import io.varnonsoft.chat.repositories.CommentRepository;
import io.varnonsoft.chat.repositories.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
public class TimelineServiceImpl implements TimelineService {

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    public TimelineServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Mono<List<Post>> getFeeds(int offset, int size) {
        return postRepository.findAllByOrderByTimestampDesc(PageRequest.of(offset, size))
                             .collectList();
    }

    @Override
    public Mono<Post> getSpecificPost(UUID postId) {
        return postRepository.findById(postId);
    }

    @Override
    public Mono<List<Comment>> getComments(UUID postId) {
        return commentRepository.findByPostId(postId)
                                .collectList();
    }
}
