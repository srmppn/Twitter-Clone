package io.varnonsoft.chat.saga;

import io.varnonsoft.chat.messaging.Message;

public interface SagaPattern<M extends Message<?>> {
    void beforeStart();
    void beforeEnd();
}
