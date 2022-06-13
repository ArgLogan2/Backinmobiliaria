
package com.proinmob.inmobiliaria.controller;

import com.proinmob.inmobiliaria.model.Usuarios;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
//------------------------------------- USUARIO ------------------------------------
   @PostMapping("/user/new")
    public void agregaUser(@RequestBody Usuarios user ){
        user.setPassword(encripta(user.getPassword()));
        userServ.crearUser(user);
    }
    @GetMapping("/user/ver")
    @ResponseBody    
    public List<Usuarios> verUser(){
        return userServ.verUsuario();
    }
    @DeleteMapping ("/user/delete/{id}")
    public void borrarUser ( @PathVariable Long id){
        userServ.borraUser(id);
    }
    @PutMapping("/user/update")
    public void acualizaUser(@RequestBody Usuarios user ){
        user.setPassword(encripta(user.getPassword()));
        user.setNuevo(false);
        userServ.actualizaUser(user);
    }   
    @PostMapping("/user/ok")
    @ResponseBody    
    public boolean verUser(@RequestBody Usuarios user){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        
        List<Usuarios> usuarios =  userServ.verUsuario();
        
        for( Usuarios x:usuarios){
            if((argon2.verify(x.getPassword(), user.getPassword()))&&(x.getUsuario().equals(user.getUsuario())) ){
                x.setValido(true);
                return true;
            }
   
        }
        return false;
    }
    private String encripta(String pass){
         Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
         String hash = argon2.hash(1, 1024, 1, pass);
        return hash;
    }
 //----------------------------------------------------------------------------------  
    
}
