package ch.dso.kafka.producer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResource {

    private final String user;
    private final String message;

    public MessageResource(String user, String message) {
       this.user = user;
       this.message = message;
    }

}
