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
public class Owner implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)     
    private Long id;
    
    private String name;
    private String surname;
    
    /* Se genera una FK que trae objetos Property */
    
    public Owner() {
    }

    public Owner(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

}