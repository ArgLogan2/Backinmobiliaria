package com.proinmob.inmobiliaria.service;

import com.proinmob.inmobiliaria.model.Owner;
import java.util.List;

public interface IOwnerService {
    public List<Owner> verOwner();
    
    public void crearOwner(Owner local);
    
    public void borrarOwner (Long id);
    
    public Owner buscarOwner (Long id);
    
    public void actualizarOwner (Owner local);
}
