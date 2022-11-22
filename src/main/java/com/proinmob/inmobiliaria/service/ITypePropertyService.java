package com.proinmob.inmobiliaria.service;

import com.proinmob.inmobiliaria.model.TypeProperty;
import java.util.List;

public interface ITypePropertyService {
    public List<TypeProperty> verTypeProperty();
    
    public void crearTypeProperty(TypeProperty local);
    
    public void borrarTypeProperty (Long id);
    
    public TypeProperty buscarTypeProperty (Long id);
    
    public void actualizarTypeProperty (TypeProperty local);
}