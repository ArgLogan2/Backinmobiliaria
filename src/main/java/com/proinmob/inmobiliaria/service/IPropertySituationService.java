package com.proinmob.inmobiliaria.service;

import com.proinmob.inmobiliaria.model.PropertySituation;
import java.util.List;

public interface IPropertySituationService {
    public List<PropertySituation> verPropertySituation();
    
    public void crearPropertySituation(PropertySituation local);
    
    public void borrarPropertySituation (Long id);
    
    public PropertySituation buscarPropertySituation (Long id);
    
    public void actualizarPropertySituation (PropertySituation local);
}