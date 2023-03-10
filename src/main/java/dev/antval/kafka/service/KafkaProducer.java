package dev.antval.kafka.service;

import com.github.javafaker.Faker;
import dev.antval.kafka.avro.Hobbit;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
class KafkaProducer{
    private final KafkaTemplate<Integer,Hobbit> template;

    Faker faker;

    @EventListener(ApplicationStartedEvent.class)
    public void generate(){
        faker = Faker.instance();
        final Flux<Long> interval = Flux.interval(Duration.ofMillis(19_000));

        final Flux<String> quotes = Flux.fromStream(Stream.generate(() -> faker.hobbit().quote()));

        Flux.zip(interval, quotes)
                .map(it -> template.send("hobbit-avro", faker.random().nextInt(42), new Hobbit(it.getT2()))).blockLast();
    }
}
