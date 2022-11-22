package com.proinmob.inmobiliaria.service;

import com.proinmob.inmobiliaria.model.Property;
import java.util.List;

public interface IPropertyService {
    public List<Property> verProperty();
    
    public void crearProperty(Property local);
    
    public void borrarProperty (Long id);
    
    public Property buscarProperty (Long id);
    
    public void actualizarProperty (Property local);
}
