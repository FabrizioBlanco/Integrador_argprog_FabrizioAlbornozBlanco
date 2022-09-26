
package com.proyecto.integrador.Security.Entitiy;





public class Usuario {
    private int id;
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;
    private Set<Rol> roles = HashSet<>();
    
   
