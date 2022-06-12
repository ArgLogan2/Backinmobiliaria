
package com.proinmob.inmobiliaria.service;

import com.proinmob.inmobiliaria.model.Inmobiliaria;
import com.proinmob.inmobiliaria.repository.InmobiliariaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InmobiliariaService implements IInmobiliariaService{
    @Autowired
    public InmobiliariaRepository Inmobiliariarepo;
    
    @Override
    public List<Inmobiliaria> verComponente() {
        return Inmobiliariarepo.findAll();
    }

    @Override
    public void crearComponente(Inmobiliaria dato) {
        Inmobiliariarepo.save(dato);
    }

    @Override
    public void borraComponente(Long id) {
        Inmobiliariarepo.deleteById(id);
    }

    @Override
    public Inmobiliaria buscaComponente(Long id) {
        return Inmobiliariarepo.findById(id).orElse(null);
    }

    @Override
    public void actualizaComponente(Inmobiliaria dato) {
        Inmobiliariarepo.save(dato);
    }
    
}
