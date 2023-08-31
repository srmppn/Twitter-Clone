package io.varnonsoft.chat.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {
    @Bean
    public NewTopic postTopic() {
        return new NewTopic(KafkaTopic.POST, 2, (short) 2);
    }

    @Bean
    public NewTopic commentTopic() {
        return new NewTopic(KafkaTopic.COMMENT, 2, (short) 2);
    }
}
