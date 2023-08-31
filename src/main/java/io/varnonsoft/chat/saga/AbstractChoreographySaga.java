package io.varnonsoft.chat.saga;

import io.varnonsoft.chat.messaging.Message;
import io.varnonsoft.chat.repositories.OutboxRepository;

abstract class AbstractChoreographySaga<E> implements ChoreographySaga<Message<E>, E> {

    private final OutboxRepository outboxRepository;

    protected AbstractChoreographySaga(OutboxRepository outboxRepository) {
        this.outboxRepository = outboxRepository;
    }

    @Override
    public void on(E event) {
        try {
            beforeStart();
            onTransaction(event);
            beforeEnd();
        }
        catch (Exception error) {
            compensate(event);
        }
    }

    abstract void onTransaction(E event);


    @Override
    public void beforeStart() {
        // do nothing yet
    }

    @Override
    public void beforeEnd() {
        // do nothing yet
    }
}
