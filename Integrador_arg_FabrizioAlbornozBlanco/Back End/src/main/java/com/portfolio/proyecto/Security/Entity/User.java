
package com.portfolio.proyecto.Security.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Column(unique=true)
    private String name;
    
    @NotNull
    @Column(unique=true)
    private String userName;
    
    @NotNull    
    private String email;
    
    @NotNull    
    private String password;
    
    //relacionamos tablas
    
    @ManyToMany(fetch = FetchType.EAGER)
    //creamos la tabla
    @JoinTable(name="user_rol",
            //la tabla tiene 2 columnas "user_id" y "rol_id"
            joinColumns= @JoinColumn(name = "user_id"), 
            inverseJoinColumns = @JoinColumn (name="rol_id"))
    
    //esto "une" lo de arriba"
    private Set<Rol> roles = new HashSet<>();
    public User(){}
    public User(String name, String userName, String email, String password) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    
    
}
