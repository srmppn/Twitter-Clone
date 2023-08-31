package io.varnonsoft.chat.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPayload {
    private UUID senderId;
    private String content;
}
