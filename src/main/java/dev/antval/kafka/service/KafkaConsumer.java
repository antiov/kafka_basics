package dev.antval.kafka.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KafkaConsumer {
    @KafkaListener(topics = {"streams-wordcount-output"}, groupId = "spring-boot-kafka")
    public void consume(ConsumerRecord<String,Long> record){
        System.out.println("received = " + record.value() + " with key " + record.key());
    }
}
