package io.varnonsoft.chat.repositories;

import io.varnonsoft.chat.saga.outbox.Outbox;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface OutboxRepository extends ReactiveCrudRepository<Outbox, UUID> {

}
