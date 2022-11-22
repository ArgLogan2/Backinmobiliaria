package com.proinmob.inmobiliaria.model;

import java.io.Serializable;
import javax.persistence.Column;
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
public class Property implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)     
    private Long id;
    
    private String tittle;
    private String currency;
    private Long price ;
    private Long land;
    private Long covered;
    private Long rooms;
    private Long bathrooms;
    private Boolean featured;
    @Column(name="DESCRIPTION", length=1000)
    private String description;
    

    /* Las variables planteadas como arrays fueron convertidas en otras Entitys
    las cuales hacen referencia a esta Entity generandose en esta ambas FK: Image e Information*/
    
    @ManyToOne
    @JoinColumn(name="owner")
    Owner owner;
    
    @ManyToOne
    @JoinColumn(name="location")
    Location location;
    
    @ManyToOne
    @JoinColumn(name="typeProperty")
    TypeProperty typeProperty;
    
    @ManyToOne
    @JoinColumn(name="propertySituation")
    PropertySituation propertySituation;
    
    

    public Property() {
    }

    public Property(Long id, String tittle, String currency, Long price, Long land, Long covered, Long rooms, Long bathrooms, Boolean featured, String description, Owner owner, Location location, TypeProperty typeProperty, PropertySituation propertySituation) {
        this.id = id;
        this.tittle = tittle;
        this.currency = currency;
        this.price = price;
        this.land = land;
        this.covered = covered;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.featured = featured;
        this.description = description;
        this.owner = owner;
        this.location = location;
        this.typeProperty = typeProperty;
        this.propertySituation = propertySituation;
    }   
}