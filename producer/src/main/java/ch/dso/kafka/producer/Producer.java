package ch.dso.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

@Service
@Slf4j
public class Producer {


    enum Topic{
        USER("user",User.class),
        USER_ONE_P("user-one-p",User.class),
        CAR("car", Car.class),
        MESSAGE("message", Message.class);

        public final String topicName;
        public final Class type;

        Topic(String topicName, Class type){
            this.topicName = topicName;
            this.type = type;
        }


    }

    @Value("${topic.name}")
    private String TOPIC;

    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void sendMessageForTopic(Topic topic, Object message) {
        this.kafkaTemplate.send(topic.topicName, message);
        log.info(String.format("Produced kafka message -> %s", message));
    }

    void sendMessageForTopicWithKey(Topic topic, String key, Object message) {
        this.kafkaTemplate.send(topic.topicName, key, message);
        log.info(String.format("Produced kafka message with key -> %s -> %s", key, message));
    }


}
