package io.varnonsoft.chat.saga;

import io.varnonsoft.chat.messaging.Message;

public interface ChoreographySaga<M extends Message<E>, E> extends SagaPattern<M> {
    void on(E event);
    void compensate(E event);
}
