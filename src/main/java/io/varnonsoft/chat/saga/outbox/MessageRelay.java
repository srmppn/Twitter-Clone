package io.varnonsoft.chat.saga.outbox;

public interface MessageRelay<O extends Outbox<?>> {
    void on();

    O getOutbox();
}
