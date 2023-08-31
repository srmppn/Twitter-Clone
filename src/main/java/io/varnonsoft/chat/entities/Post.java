package io.varnonsoft.chat.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@AllArgsConstructor
public class Post {
    @Id
    private UUID postId;
    private UUID senderId;
    private String content;
    private Long timestamp;
}