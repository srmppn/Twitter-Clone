package io.varnonsoft.chat.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@KafkaListener(topics = "", groupId = "", topicPartitions = {})
public @interface MessageConsumer {
    String[] topics() default {};
    String groupId() default "";

    TopicPartition[] topicPartitions() default {};
}
