package io.varnonsoft.chat.controllers;

import io.varnonsoft.chat.api.PostPayload;
import io.varnonsoft.chat.config.KafkaPartition;
import io.varnonsoft.chat.config.KafkaTopic;
import io.varnonsoft.chat.messaging.MessageBroker;
import io.varnonsoft.chat.messaging.kafka.KafkaMessage;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin("*")
@RequestMapping("/post")
public class PostController {

    private final MessageBroker<KafkaMessage<?, ?>> messageBroker;

    public PostController(MessageBroker<KafkaMessage<?, ?>> messageBroker) {
        this.messageBroker = messageBroker;
    }

    @PostMapping
    public Mono<String> createPost(@RequestBody PostPayload body) {
        return messageBroker.publish(KafkaMessage.asGenericMessage(KafkaTopic.POST, body, KafkaPartition.POST));
    }
}