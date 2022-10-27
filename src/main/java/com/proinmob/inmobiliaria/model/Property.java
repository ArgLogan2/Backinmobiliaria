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
public class Property implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)     
    private Long id;
    
    private String tittle;
    private Long price ;

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
    PropertySituation propertySituatio;
    
    public Property() {
    }    

    public Property(Long id, String tittle, Long price, Owner owner, Location location, TypeProperty typeProperty, PropertySituation propertySituatio) {
        this.id = id;
        this.tittle = tittle;
        this.price = price;
        this.owner = owner;
        this.location = location;
        this.typeProperty = typeProperty;
        this.propertySituatio = propertySituatio;
    }
}