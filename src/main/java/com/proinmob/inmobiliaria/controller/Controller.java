
package com.proinmob.inmobiliaria.controller;

import com.proinmob.inmobiliaria.model.Inmobiliaria;
import com.proinmob.inmobiliaria.service.IInmobiliariaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    IInmobiliariaService inmobiliariaService;
    

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
}
