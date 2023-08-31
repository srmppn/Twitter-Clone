package io.varnonsoft.chat.consumer;

import io.varnonsoft.chat.api.CommentPayload;
import io.varnonsoft.chat.api.PostPayload;
import io.varnonsoft.chat.config.KafkaGroup;
import io.varnonsoft.chat.config.KafkaPartition;
import io.varnonsoft.chat.config.KafkaTopic;
import io.varnonsoft.chat.messaging.MessageConsumer;
import io.varnonsoft.chat.services.CommentService;
import io.varnonsoft.chat.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;


@Component
public class PostListener {

    private static final Logger logger = LoggerFactory.getLogger(PostListener.class);
    private final PostService postService;


    public PostListener(PostService postService) {
        this.postService = postService;
    }

    @MessageConsumer(topics = KafkaTopic.POST,
                     groupId = KafkaGroup.POST_GROUP,
                     topicPartitions = { @TopicPartition(topic = KafkaTopic.POST, partitions = { KafkaPartition.POST })})
    public void on(@Payload PostPayload payload,
                   @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long timestamp) {
        postService.createPost(payload.getSenderId(), payload.getContent(), timestamp)
                   .block();
    }
}
