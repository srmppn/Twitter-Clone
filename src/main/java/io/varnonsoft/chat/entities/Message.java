package io.varnonsoft.chat.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Message {
    @Id
    private UUID messageId;
    private UUID senderId;
    private UUID receiverId;
    private String message;
    private Long timestamp;
}
