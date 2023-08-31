package io.varnonsoft.chat.entities;

import io.varnonsoft.chat.saga.OrderCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private UUID orderId;

    public static Order fromEvent(OrderCreatedEvent event) {
        return new Order();
    }
}
