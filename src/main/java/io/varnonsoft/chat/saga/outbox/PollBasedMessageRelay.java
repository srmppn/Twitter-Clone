package io.varnonsoft.chat.saga.outbox;

import io.varnonsoft.chat.repositories.OutboxRepository;
import org.springframework.scheduling.annotation.Scheduled;

public class PollBasedMessageRelay implements MessageRelay<Outbox<?>> {

    private final OutboxRepository outboxRepository;

    public PollBasedMessageRelay(OutboxRepository outboxRepository) {
        this.outboxRepository = outboxRepository;
    }

    @Override
    @Scheduled
    public void on() {

    }

    @Override
    public Outbox<?> getOutbox() {
        return this.outboxRepository.findById();
    }
}
