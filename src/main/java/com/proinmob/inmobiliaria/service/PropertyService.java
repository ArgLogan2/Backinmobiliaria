package com.proinmob.inmobiliaria.service;

import com.proinmob.inmobiliaria.model.Property;
import com.proinmob.inmobiliaria.repository.PropertyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IPropertyService{
    @Autowired
    public PropertyRepository Propertyrepo;
    
    @Override
    public List<Property> verProperty() {
         return Propertyrepo.findAll();
    }

    @Override
    public void crearProperty(Property local) {
        Propertyrepo.save(local);
    }

    @Override
    public void borrarProperty(Long id) {
        Propertyrepo.deleteById(id);
    }

    @Override
    public Property buscarProperty(Long id) {
        return Propertyrepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarProperty(Property local) {
        Propertyrepo.save(local);
    }   
}