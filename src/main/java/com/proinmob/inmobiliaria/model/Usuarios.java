
package com.proinmob.inmobiliaria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Nombre;
    private String Apellido;
    private String email;
    private String password;
    private boolean admin;
    private boolean  nuevo;
    private boolean valido;
   
    public Usuarios() {
    }

    public Usuarios(Long id, String Nombre, String Apellido, String email, String password, boolean admin, boolean nuevo, boolean valido) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.nuevo = nuevo;
        this.valido = valido;
    }

    

    
   
}
