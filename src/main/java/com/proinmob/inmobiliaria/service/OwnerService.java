package com.proinmob.inmobiliaria.service;


import com.proinmob.inmobiliaria.model.Owner;
import com.proinmob.inmobiliaria.repository.OwnerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService implements IOwnerService{
    @Autowired
    public OwnerRepository Ownerrepo;
    
    @Override
    public List<Owner> verOwner() {
         return Ownerrepo.findAll();
    }

    @Override
    public void crearOwner(Owner local) {
        Ownerrepo.save(local);
    }

    @Override
    public void borrarOwner(Long id) {
        Ownerrepo.deleteById(id);
    }

    @Override
    public Owner buscarOwner(Long id) {
        return Ownerrepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarOwner(Owner local) {
        Ownerrepo.save(local);
    }   
}