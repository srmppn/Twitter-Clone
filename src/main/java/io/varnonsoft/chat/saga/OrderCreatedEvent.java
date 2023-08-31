package io.varnonsoft.chat.saga;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderCreatedEvent {
    private UUID orderId;
}
