package io.varnonsoft.chat.services;

import io.varnonsoft.chat.entities.Comment;
import io.varnonsoft.chat.entities.Post;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface TimelineService {
    Mono<List<Post>> getFeeds(int offset, int size);

    Mono<Post> getSpecificPost(UUID postId);

    Mono<List<Comment>> getComments(UUID postId);

}
