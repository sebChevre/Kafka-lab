package ch.dso.kafka.producer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResource {

    private final String nom;
    private final Integer age;
    private final String prenom;

    public UserResource(String nom, String prenom, Integer age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

}
