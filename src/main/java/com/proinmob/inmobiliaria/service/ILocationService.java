package com.proinmob.inmobiliaria.service;

import com.proinmob.inmobiliaria.model.Location;
import java.util.List;

public interface ILocationService {
    public List<Location> verLocation();
    
    public void crearLocation(Location local);
    
    public void borrarLocation (Long id);
    
    public Location buscarLocation (Long id);
    
    public void actualizarLocation (Location local);
}