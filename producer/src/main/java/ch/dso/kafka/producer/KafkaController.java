package ch.dso.kafka.producer;

import ch.dso.kafka.producer.dto.CarResource;
import ch.dso.kafka.producer.dto.MessageResource;
import ch.dso.kafka.producer.dto.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/topic")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/user")
    public void sendMessageToKafkaUserTopic(@RequestParam(required = false) String key, @RequestBody UserResource userResource) {
        User user = new User(userResource.getNom(),userResource.getPrenom(),userResource.getAge());

        if(key != null){
            this.producer.sendMessageForTopicWithKey(Producer.Topic.USER,key, user);
        }else{
            this.producer.sendMessageForTopic(Producer.Topic.USER, user);
        }
    }

    @PostMapping(value = "/user-one-p")
    public void sendMessageToKafkaUserOnePatitionTopic(@RequestParam(required = false) String key, @RequestBody UserResource userResource) {
        User user = new User(userResource.getNom(),userResource.getPrenom(),userResource.getAge());

        if(key != null){
            this.producer.sendMessageForTopicWithKey(Producer.Topic.USER_ONE_P,key, user);
        }else{
            this.producer.sendMessageForTopic(Producer.Topic.USER_ONE_P, user);
        }
    }

    @PostMapping(value = "/car")
    public void sendMessageToKafkaCarTopic(@RequestParam(required = false) String key, @RequestBody CarResource carResource) {
        Car car = new Car(carResource.getModele(), carResource.getMarque(), carResource.getMiseCirculation());

        if(key != null){
            this.producer.sendMessageForTopicWithKey(Producer.Topic.CAR,key, car);
        }else{
            this.producer.sendMessageForTopic(Producer.Topic.CAR, car);
        }
    }

    @PostMapping(value = "/message")
    public void sendMessageToKafkaMessageTopic(@RequestParam(required = false) String key, @RequestBody MessageResource messageResource) {
        Message message = new Message(messageResource.getUser(),messageResource.getMessage());

        if(key != null){
            this.producer.sendMessageForTopicWithKey(Producer.Topic.MESSAGE,key, message);
        }else{
            this.producer.sendMessageForTopic(Producer.Topic.MESSAGE,message);
        }
    }

}
