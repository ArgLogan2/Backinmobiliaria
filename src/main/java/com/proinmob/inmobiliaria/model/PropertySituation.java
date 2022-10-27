package com.proinmob.inmobiliaria.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class PropertySituation implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)     
    private Long id;
    
    private String situation;
    
    /* Se genera una FK que trae objetos Property */

    public PropertySituation() {
    }

    public PropertySituation(Long id, String situation) {
        this.id = id;
        this.situation = situation;
    }

}