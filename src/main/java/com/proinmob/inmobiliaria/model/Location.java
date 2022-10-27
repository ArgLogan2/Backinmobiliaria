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
public class Location implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)     
    private Long id;
    
    private String name;
    
    /* Se genera una FK que trae objetos Property */

    public Location() {
    }

    public Location(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}