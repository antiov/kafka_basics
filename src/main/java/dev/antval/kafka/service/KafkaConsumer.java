package dev.antval.kafka.service;

import dev.antval.kafka.avro.Hobbit;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KafkaConsumer {
    @KafkaListener(topics = {"hobbit-avro"}, groupId = "spring-boot-kafka")
    public void consume(ConsumerRecord<Integer, Hobbit> record){
        System.out.println("received = " + record.value() + " with key " + record.key());
    }
}
