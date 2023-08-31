package io.varnonsoft.chat.messaging.kafka;

import io.varnonsoft.chat.messaging.MessageBroker;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
public class KafkaMessageBroker implements MessageBroker<KafkaMessage<String, Object>> {

    private final KafkaTemplate<String, Object> kafkaTemplate;


    public KafkaMessageBroker(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Mono<String> publish(KafkaMessage<String, Object> message) {
        return Mono.fromFuture(this.kafkaTemplate.send(message.getTopic(), Integer.parseInt(message.getPartition()), message.getKey(), message.getPayload()))
                   .map(d -> d.getProducerRecord().key());
    }
}
