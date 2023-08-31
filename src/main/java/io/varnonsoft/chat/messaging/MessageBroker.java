package io.varnonsoft.chat.messaging;

import reactor.core.publisher.Mono;

public interface MessageBroker<M extends Message> {
    Mono<String> publish(M message);
}
