
package com.proinmob.inmobiliaria.service;


import com.proinmob.inmobiliaria.model.TypeProperty;
import com.proinmob.inmobiliaria.repository.TypePropertyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypePropertyService implements ITypePropertyService{
    @Autowired
    public TypePropertyRepository TypePropertyrepo;
    
    @Override
    public List<TypeProperty> verTypeProperty() {
         return TypePropertyrepo.findAll();
    }

    @Override
    public void crearTypeProperty(TypeProperty local) {
        TypePropertyrepo.save(local);
    }

    @Override
    public void borrarTypeProperty(Long id) {
        TypePropertyrepo.deleteById(id);
    }

    @Override
    public TypeProperty buscarTypeProperty(Long id) {
        return TypePropertyrepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarTypeProperty(TypeProperty local) {
        TypePropertyrepo.save(local);
    }   
}