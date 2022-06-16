
package com.proinmob.inmobiliaria.service;

import com.proinmob.inmobiliaria.model.Usuarios;
import java.util.List;

public interface IUsuariosService {
    public List<Usuarios> verUsuaarios();
    
    public void crearUsuaarios( Usuarios dato);
    
    public void borraUsuaarios (Long id);
    
    public Usuarios buscaUsuaarios (Long id);
    
    public void actualizaUsuaarios (Usuarios dato);
    
}
