
package com.portfolio.proyecto.Interface;

import com.portfolio.proyecto.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //traigo una lista de personas con el metodo getPersona
    public List<Persona> getPersona();
    //Guardamos la persona
    public void savePersona(Persona persona);
    
    //eliminar una persona
    public void deletePersona(Long id);
    
    //buscar persona
    public Persona findPersona(Long id);
}
