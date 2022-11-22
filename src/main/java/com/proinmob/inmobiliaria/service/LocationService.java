
package com.proinmob.inmobiliaria.service;


import com.proinmob.inmobiliaria.model.Location;
import com.proinmob.inmobiliaria.repository.LocationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService implements ILocationService{
    @Autowired
    public LocationRepository Locationrepo;
    
    @Override
    public List<Location> verLocation() {
         return Locationrepo.findAll();
    }

    @Override
    public void crearLocation(Location local) {
        Locationrepo.save(local);
    }

    @Override
    public void borrarLocation(Long id) {
        Locationrepo.deleteById(id);
    }

    @Override
    public Location buscarLocation(Long id) {
        return Locationrepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarLocation(Location local) {
        Locationrepo.save(local);
    }   
}