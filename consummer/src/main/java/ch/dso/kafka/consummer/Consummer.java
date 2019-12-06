package ch.dso.kafka.consummer;

import ch.dso.kafka.producer.Message;
import ch.dso.kafka.producer.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class Consummer {

    @Value("${topic.name}")
    private String topicName;

    @KafkaListener(topics = "user")
    public void consumeUser(ConsumerRecord<String, User> record) {
        Arrays.asList(record.headers().toArray()).forEach(header -> {
            log.info(header.key());
            log.info(header.value().toString());
        });
        log.info(String.format("Consumed message -> %s", record.value()));
    }

    @KafkaListener(topics = "message")
    public void consumeMessage(ConsumerRecord<String, Message> record) {
        Arrays.asList(record.headers().toArray()).forEach(header -> {
            log.info(header.key());
            log.info(header.value().toString());
        });
        log.info(String.format("Consumed message -> %s", record.value()));
    }

    @KafkaListener(topics = "car")
    public void consumeCar(ConsumerRecord<String, Object> record) {
        Arrays.asList(record.headers().toArray()).forEach(header -> {
            log.info(header.key());
            log.info(header.value().toString());
        });
        log.info(String.format("Consumed message -> %s", record.value()));
    }


}
