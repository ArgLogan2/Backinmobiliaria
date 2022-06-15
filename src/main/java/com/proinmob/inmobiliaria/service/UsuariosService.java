
package com.proinmob.inmobiliaria.service;

import com.proinmob.inmobiliaria.model.Usuarios;
import com.proinmob.inmobiliaria.repository.UsuariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService implements IUsuariosService{
    @Autowired
    public UsuariosRepository usuariosrepo;
    @Override
    public List<Usuarios> verUsuaarios() {
        return usuariosrepo.findAll();
    }

    @Override
    public void crearUsuaarios(Usuarios dato) {
        usuariosrepo.save(dato);
    }

    @Override
    public void borraUsuaarios(Long id) {
        usuariosrepo.deleteById(id);
    }

    @Override
    public Usuarios buscaUsuaarios(Long id) {
        return usuariosrepo.findById(id).orElse(null);
    }

    @Override
    public void actualizaUsuaarios(Usuarios dato) {
        usuariosrepo.save(dato);
    }
    
}
