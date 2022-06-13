package com.proinmob.inmobiliaria.service;

import com.proinmob.inmobiliaria.model.Inmobiliaria;
import java.util.List;

public interface IInmobiliariaService {
    public List<Inmobiliaria> verInmobiliaria();
    
    public void crearInmobiliaria( Inmobiliaria dato);
    
    public void borraInmobiliaria (Long id);
    
    public Inmobiliaria buscaInmobiliaria (Long id);
    
    public void actualizaInmobiliaria (Inmobiliaria dato);
}
