package ch.dso.kafka.producer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResource {

    private final String modele;
    private final Integer miseCirculation;
    private final String marque;

    public CarResource(String modele, String marque, Integer miseCirculation) {
       this.marque = marque;
       this.modele = modele;
       this.miseCirculation = miseCirculation;
    }

}
