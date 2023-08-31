package io.varnonsoft.chat.saga;

import io.varnonsoft.chat.config.KafkaGroup;
import io.varnonsoft.chat.config.KafkaTopic;
import io.varnonsoft.chat.entities.Order;
import io.varnonsoft.chat.messaging.Message;
import io.varnonsoft.chat.messaging.MessageBroker;
import io.varnonsoft.chat.messaging.MessageConsumer;
import io.varnonsoft.chat.messaging.kafka.KafkaMessage;
import io.varnonsoft.chat.repositories.OrderRepository;

// @Component
public class OrderPlacementSaga extends AbstractChoreographySaga<OrderCreatedEvent> {

    private final MessageBroker<Message<?>> messageBroker;
    private final OrderRepository orderRepository;

    public OrderPlacementSaga(MessageBroker<Message<?>> messageBroker, OrderRepository orderRepository) {
        super(outboxRepository);
        this.messageBroker = messageBroker;
        this.orderRepository = orderRepository;
    }

    @Override
    @MessageConsumer(topics = KafkaTopic.ORDER, groupId = KafkaGroup.ORDER_GROUP)
    public void on(OrderCreatedEvent event) {
        super.on(event);
    }


    @Override
    void onTransaction(OrderCreatedEvent event) {
        // todo outbox pattern
        var order = Order.fromEvent(event);
        orderRepository.save(order);
//        messageBroker.publish(
//                KafkaMessage.asGenericMessage(
//                        KafkaTopic.ORDER,
//                        PaymentCreatedEvent.fromOrder(order)));
    }

    @Override
    public void compensate(OrderCreatedEvent event) {
        orderRepository.deleteById(event.getOrderId());
    }
}
