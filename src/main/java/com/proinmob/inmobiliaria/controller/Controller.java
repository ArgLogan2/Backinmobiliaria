
package com.proinmob.inmobiliaria.controller;

import com.proinmob.inmobiliaria.model.Usuarios;
import com.proinmob.inmobiliaria.service.IUsuariosService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import com.proinmob.inmobiliaria.model.Inmobiliaria;
import com.proinmob.inmobiliaria.model.Location;
import com.proinmob.inmobiliaria.model.Owner;
import com.proinmob.inmobiliaria.model.PropertySituation;
import com.proinmob.inmobiliaria.model.TypeProperty;
import com.proinmob.inmobiliaria.model.Property;
import com.proinmob.inmobiliaria.service.IInmobiliariaService;
import com.proinmob.inmobiliaria.service.ILocationService;
import com.proinmob.inmobiliaria.service.IOwnerService;
import com.proinmob.inmobiliaria.service.IPropertyService;
import com.proinmob.inmobiliaria.service.IPropertySituationService;
import com.proinmob.inmobiliaria.service.ITypePropertyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired IInmobiliariaService inmobiliariaService;
    @Autowired IUsuariosService userServ;
    @Autowired ILocationService locationService;
    @Autowired IOwnerService ownerService;
    @Autowired ITypePropertyService typepropertyService;
    @Autowired IPropertySituationService propertysituationService;
    @Autowired IPropertyService propertyService;
//------------------------------------- USUARIO ------------------------------------
   @PostMapping("/user/new")
    public void agregaUser(@RequestBody Usuarios user ){
        user.setPassword(encripta(user.getPassword()));
        userServ.crearUsuaarios(user);
    }
    @GetMapping("/user/ver")
    @ResponseBody    
    public List<Usuarios> verUser(){
        return userServ.verUsuaarios();
    }
    @DeleteMapping ("/user/delete/{id}")
    public void borrarUser ( @PathVariable Long id){
        userServ.borraUsuaarios(id);
    }
    @PutMapping("/user/update")
    public void acualizaUser(@RequestBody Usuarios user ){
        user.setPassword(encripta(user.getPassword()));
        user.setNuevo(false);
        userServ.actualizaUsuaarios(user);
    }   
    @PostMapping("/user/ok")
    @ResponseBody    
    public boolean verUser(@RequestBody Usuarios user){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        
        List<Usuarios> usuarios =  userServ.verUsuaarios();
        
        for( Usuarios x:usuarios){
            if((argon2.verify(x.getPassword(), user.getPassword()))&&(x.getNombre().equals(user.getNombre())) ){
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
 
//-------------------- INMOBILIARIA ----------------------------------------------   

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

    //------------------------------------------------------------------------
    


    //-----------------------Shopping Page Juanjo-----------------------------------
    
    // ----- LOCATION -----
    
    @PostMapping("/location/new")
    public void agregarLocation(@RequestBody Location local){
       locationService.crearLocation(local);
    }
    
    @GetMapping("/location/ver")
    @ResponseBody    
    public List<Location> verLocation(){
        return locationService.verLocation();
    }
    
    @GetMapping ("/location/buscar/{id}")
    public Location buscarLocation ( @PathVariable Long id){
        return locationService.buscarLocation(id);
    }
    
    @DeleteMapping ("/location/delete/{id}")
    public void borrarLocation ( @PathVariable Long id){
        locationService.borrarLocation(id);
    }
    
    @PostMapping("/location/update")
    public void acualizarLocation(@RequestBody Location local ){
        locationService.actualizarLocation(local);
    }
    
    // ----- OWNER -----
    
    @PostMapping("/owner/new")
    public void agregarOwner(@RequestBody Owner owner){
       ownerService.crearOwner(owner);
    }
    
    @GetMapping("/owner/ver")
    @ResponseBody    
    public List<Owner> verOwner(){
        return ownerService.verOwner();
    }
    
    @GetMapping ("/owner/buscar/{id}")
    public Owner buscarOwner ( @PathVariable Long id){
        return ownerService.buscarOwner(id);
    }
    
    @DeleteMapping ("/owner/delete/{id}")
    public void borrarOwner ( @PathVariable Long id){
        ownerService.borrarOwner(id);
    }
    
    @PostMapping("/owner/update")
    public void acualizarOwner(@RequestBody Owner owner ){
        ownerService.actualizarOwner(owner);
    }
    
     // ----- TYPE-PROPERTY -----
    
    @PostMapping("/typeproperty/new")
    public void agregarTypeProperty(@RequestBody TypeProperty typeproperty){
       typepropertyService.crearTypeProperty(typeproperty);
    }
    
    @GetMapping("/typeproperty/ver")
    @ResponseBody    
    public List<TypeProperty> verTypeProperty(){
        return typepropertyService.verTypeProperty();
    }
    
    @GetMapping ("/typeproperty/buscar/{id}")
    public TypeProperty buscarTypeProperty ( @PathVariable Long id){
        return typepropertyService.buscarTypeProperty(id);
    }
    
    @DeleteMapping ("/typeproperty/delete/{id}")
    public void borrarTypeProperty ( @PathVariable Long id){
        typepropertyService.borrarTypeProperty(id);
    }
    
    @PostMapping("/typeproperty/update")
    public void acualizarTypeProperty(@RequestBody TypeProperty typeproperty ){
        typepropertyService.actualizarTypeProperty(typeproperty);
    }
    
    // ----- PROPERTY-SITUATION -----
    
    @PostMapping("/propertysituation/new")
    public void agregarPropertySituation(@RequestBody PropertySituation propertysituation){
       propertysituationService.crearPropertySituation(propertysituation);
    }
    
    @GetMapping("/propertysituation/ver")
    @ResponseBody    
    public List<PropertySituation> verPropertySituation(){
        return propertysituationService.verPropertySituation();
    }
    
    @GetMapping ("/propertysituation/buscar/{id}")
    public PropertySituation buscarPropertySituation ( @PathVariable Long id){
        return propertysituationService.buscarPropertySituation(id);
    }
    
    @DeleteMapping ("/propertysituation/delete/{id}")
    public void borrarPropertySituation ( @PathVariable Long id){
        propertysituationService.borrarPropertySituation(id);
    }
    
    @PostMapping("/propertysituation/update")
    public void acualizarPropertySituation(@RequestBody PropertySituation propertysituation ){
        propertysituationService.actualizarPropertySituation(propertysituation);
    }
    
    
    // ----- PROPERTY -----
    
    @PostMapping("/property/new")
    public void agregarProperty(@RequestBody Property property){
       propertyService.crearProperty(property);
    }
    
    @GetMapping("/property/ver")
    @ResponseBody    
    public List<Property> verProperty(){
        return propertyService.verProperty();
    }
    
    @GetMapping ("/property/buscar/{id}")
    public Property buscarProperty ( @PathVariable Long id){
        return propertyService.buscarProperty(id);
    }
    
    @DeleteMapping ("/property/delete/{id}")
    public void borrarProperty ( @PathVariable Long id){
        propertyService.borrarProperty(id);
    }
    
    @PostMapping("/property/update")
    public void acualizarProperty(@RequestBody Property property ){
        propertyService.actualizarProperty(property);
    }
    
    
    //-----------------------Appraisals Page-----------------------------------
    
    //------------------------------------------------------------------------
    

    
    //-----------------------Sales Page-----------------------------------
    
    //------------------------------------------------------------------------
}