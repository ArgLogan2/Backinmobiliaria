package com.proinmob.inmobiliaria.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Information implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)     
    private Long id;
    
    private Long land;
    private Long covered;
    private Long rooms;
    private Long bathrooms;
    
    @ManyToOne
    @JoinColumn(name="property")
    Property property;
    
    public Information() {
    }

    public Information(Long id, Long land, Long covered, Long rooms, Long bathrooms, Property property) {
        this.id = id;
        this.land = land;
        this.covered = covered;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.property = property;
    }

}