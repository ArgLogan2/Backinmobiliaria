
package com.proinmob.inmobiliaria.model;

public class Usuarios {
    private Long id;
    private String Nombre;
    private String Apellido;
    private String email;
    private boolean admin;

    public Usuarios() {
    }

    public Usuarios(Long id, String Nombre, String Apellido, String email, boolean admin) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.email = email;
        this.admin = admin;
    }
    
}
