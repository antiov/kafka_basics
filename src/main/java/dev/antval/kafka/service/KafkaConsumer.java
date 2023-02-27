package dev.antval.kafka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KafkaConsumer {
    @KafkaListener(topics = {"hobbit"}, groupId = "spring-boot-kafka")
    public void consume(String quote){
        System.out.println("received = " + quote);
    }
}
