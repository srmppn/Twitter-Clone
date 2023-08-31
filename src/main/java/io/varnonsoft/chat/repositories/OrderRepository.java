package io.varnonsoft.chat.repositories;

import io.varnonsoft.chat.entities.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface OrderRepository extends ReactiveCrudRepository<Order, UUID> {
}
