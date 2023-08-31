package io.varnonsoft.chat.repositories;

import io.varnonsoft.chat.entities.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface PostRepository extends ReactiveCrudRepository<Post, UUID> {
    Flux<Post> findAllByOrderByTimestampDesc(Pageable pageable);
}
