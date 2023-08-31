package io.varnonsoft.chat.saga.outbox;

import java.util.UUID;

public interface Outbox<P> {
    UUID getIdentifier();
    P getPayload();
}
