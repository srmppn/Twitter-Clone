package io.varnonsoft.chat.saga;

import io.varnonsoft.chat.entities.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class PaymentCreatedEvent {

    private UUID paymentId;

    public static PaymentCreatedEvent fromOrder(Order order) {
        return new PaymentCreatedEvent();
    }
}
