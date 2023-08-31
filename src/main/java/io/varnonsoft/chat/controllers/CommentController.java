package io.varnonsoft.chat.controllers;

import io.varnonsoft.chat.api.CommentPayload;
import io.varnonsoft.chat.config.KafkaPartition;
import io.varnonsoft.chat.config.KafkaTopic;
import io.varnonsoft.chat.messaging.MessageBroker;
import io.varnonsoft.chat.messaging.kafka.KafkaMessage;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentController {
    private final MessageBroker<KafkaMessage<?, ?>> messageBroker;

    public CommentController(MessageBroker<KafkaMessage<?, ?>> messageBroker) {
        this.messageBroker = messageBroker;
    }

    @PostMapping
    public Mono<String> createComment(@RequestBody CommentPayload body) {
        return messageBroker.publish(KafkaMessage.asGenericMessage(KafkaTopic.COMMENT, body, KafkaPartition.COMMENT));
    }
}
