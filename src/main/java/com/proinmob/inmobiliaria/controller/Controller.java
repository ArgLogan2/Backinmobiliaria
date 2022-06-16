
package com.proinmob.inmobiliaria.controller;

<<<<<<< HEAD
import com.proinmob.inmobiliaria.model.Usuarios;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
=======
import com.proinmob.inmobiliaria.model.Inmobiliaria;
import com.proinmob.inmobiliaria.service.IInmobiliariaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 4-creación-de-capa-controladora-para-servicio-front-end-cargadatos
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PutMapping;
=======
>>>>>>> 4-creación-de-capa-controladora-para-servicio-front-end-cargadatos
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    IInmobiliariaService inmobiliariaService;
    
<<<<<<< HEAD
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
    
=======

    @PostMapping("/inmobiliaria/new")
    public void agregarInmobiliaria(@RequestBody Inmobiliaria inmobiliaria){
       inmobiliariaService.crearInmobiliaria(inmobiliaria);
    }
    
    @GetMapping("/inmobiliaria/ver")
    @ResponseBody    
    public List<Inmobiliaria> verInmobiliaria(){
        return inmobiliariaService.verInmobiliaria();
    }
    
    @GetMapping ("/inmobiliaria/buscar/{id}")
    public Inmobiliaria buscaInmobiliaria ( @PathVariable Long id){
        return inmobiliariaService.buscaInmobiliaria(id);
    }
    
    @DeleteMapping ("/inmobiliaria/delete/{id}")
    public void borrarInmobiliaria ( @PathVariable Long id){
        inmobiliariaService.borraInmobiliaria(id);
    }
    
    @PostMapping("/inmobiliaria/update")
    public void acualizaInmobiliaria(@RequestBody Inmobiliaria inmobiliaria ){
        inmobiliariaService.actualizaInmobiliaria(inmobiliaria);
    }   
>>>>>>> 4-creación-de-capa-controladora-para-servicio-front-end-cargadatos
}
