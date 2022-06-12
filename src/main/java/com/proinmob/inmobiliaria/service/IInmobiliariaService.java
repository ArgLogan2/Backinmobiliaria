package com.proinmob.inmobiliaria.service;

import com.proinmob.inmobiliaria.model.Inmobiliaria;
import java.util.List;

public interface IInmobiliariaService {
    public List<Inmobiliaria> verComponente();
    
    public void crearComponente( Inmobiliaria dato);
    
    public void borraComponente (Long id);
    
    public Inmobiliaria buscaComponente (Long id);
    
    public void actualizaComponente (Inmobiliaria dato);
}
