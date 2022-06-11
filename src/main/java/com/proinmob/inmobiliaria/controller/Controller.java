
package com.proinmob.inmobiliaria.controller;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
//------------------------------------- USUARIO ------------------------------------
    @PostMapping("/user/new")
    public void agregaUser(@RequestBody Users user ){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);
        userServ.crearUser(user);
    }
    @GetMapping("/user/ver")
    @ResponseBody    
    public List<Users> verUser(){
        return userServ.verUsers();
    }
    @DeleteMapping ("/user/delete/{id}")
    public void borrarUser ( @PathVariable Long id){
        userServ.borrarUser(id);
    }
    @PostMapping("/user/update")
    public void acualizaUser(@RequestBody Users user ){
        userServ.atualizarUser(user);
    }   
    @PostMapping("/user/ok")
    @ResponseBody    
    public boolean verUser(@RequestBody Users user){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        
        List<Users> usuarios =  userServ.verUsers();
        
        for( Users x:usuarios){
            if((argon2.verify(x.getPassword(), user.getPassword()))&&(x.getUsuario().equals(user.getUsuario())) ){
                x.setValido(true);
                return true;
            }
   
        }
        return false;
    }

//------------------------------------------------------------------------- 
    
}
