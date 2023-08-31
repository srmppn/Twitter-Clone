package io.varnonsoft.chat.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPayload {
    private UUID postId;
    private UUID senderId;
    private String content;
}
