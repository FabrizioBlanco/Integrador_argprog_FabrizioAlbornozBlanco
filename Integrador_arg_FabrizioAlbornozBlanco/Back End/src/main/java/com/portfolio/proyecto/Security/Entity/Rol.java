
package com.portfolio.proyecto.Security.Entity;

import com.portfolio.proyecto.Security.Enums.RolNombre;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Rol {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Enumerated(EnumType.STRING) //acá le definimos que sean datos de tipo String, si o sí.
    private RolNombre rolnombre;

    public Rol(){}
    public Rol(RolNombre rolnombre) {
       this.rolnombre = rolnombre;
    }
    
    
}
