
package com.proinmob.inmobiliaria.service;


import com.proinmob.inmobiliaria.model.PropertySituation;
import com.proinmob.inmobiliaria.repository.PropertySituationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertySituationService implements IPropertySituationService{
    @Autowired
    public PropertySituationRepository PropertySituationrepo;
    
    @Override
    public List<PropertySituation> verPropertySituation() {
         return PropertySituationrepo.findAll();
    }

    @Override
    public void crearPropertySituation(PropertySituation local) {
        PropertySituationrepo.save(local);
    }

    @Override
    public void borrarPropertySituation(Long id) {
        PropertySituationrepo.deleteById(id);
    }

    @Override
    public PropertySituation buscarPropertySituation(Long id) {
        return PropertySituationrepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarPropertySituation(PropertySituation local) {
        PropertySituationrepo.save(local);
    }   
}