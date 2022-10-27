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
public class Image implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)     
    private Long id;
    
    private String url;
    private String tittle;
    
    @ManyToOne
    @JoinColumn(name="property")
    Property property;
    
    public Image() {
    }

    public Image(Long id, String url, String tittle, Property property) {
        this.id = id;
        this.url = url;
        this.tittle = tittle;
        this.property = property;
    }
}