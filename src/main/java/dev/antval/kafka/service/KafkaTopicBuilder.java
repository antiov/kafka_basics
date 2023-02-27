package dev.antval.kafka.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaTopicBuilder {
    @Bean
    NewTopic hobbit2() {
        return TopicBuilder.name("hobbit2").partitions(5).replicas(3).build();
    }

}
