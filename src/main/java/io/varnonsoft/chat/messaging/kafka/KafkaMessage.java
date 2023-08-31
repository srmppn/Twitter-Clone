package io.varnonsoft.chat.messaging.kafka;

import io.varnonsoft.chat.messaging.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KafkaMessage<T, P> implements Message<P> {

    private T topic;


    private P payload;

    private String key;

    private String partition;

    @Override
    public P getPayload() {
        return payload;
    }

    public static <T, P> KafkaMessage<T, P> asGenericMessage(T topic, P payload, String partition) {
        return new KafkaMessage<>(topic, payload, UUID.randomUUID().toString(), partition);
    }
}
