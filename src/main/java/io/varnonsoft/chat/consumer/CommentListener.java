package io.varnonsoft.chat.consumer;

import io.varnonsoft.chat.api.CommentPayload;
import io.varnonsoft.chat.config.KafkaGroup;
import io.varnonsoft.chat.config.KafkaPartition;
import io.varnonsoft.chat.config.KafkaTopic;
import io.varnonsoft.chat.messaging.MessageConsumer;
import io.varnonsoft.chat.services.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CommentListener {
    private static final Logger logger = LoggerFactory.getLogger(PostListener.class);

    private final CommentService commentService;

    public CommentListener(CommentService commentService) {
        this.commentService = commentService;
    }

    @MessageConsumer(topics = KafkaTopic.COMMENT,
                     groupId = KafkaGroup.COMMENT_GROUP,
                     topicPartitions = { @TopicPartition(topic = KafkaTopic.COMMENT, partitions = { KafkaPartition.COMMENT })})
    public void on(@Payload CommentPayload payload,
                   @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long timestamp) {
        logger.info("consume comment message");
        commentService.createComment(payload.getPostId(), payload.getSenderId(), payload.getContent(), timestamp)
                      .block();
    }
}
