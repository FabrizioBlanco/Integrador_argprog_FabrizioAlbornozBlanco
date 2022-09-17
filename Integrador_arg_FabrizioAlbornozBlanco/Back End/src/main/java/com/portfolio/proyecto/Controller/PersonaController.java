package com.portfolio.proyecto.Controller;

import com.portfolio.proyecto.Entity.Persona;
import com.portfolio.proyecto.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;



@RestController
@CrossOrigin  (origins = "http://localhost:4200") //sirve para que acepte las peticiones desde esa página
public class PersonaController {
    @Autowired
    IPersonaService ipersonaService; 
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona){
     
        ipersonaService.savePersona(persona);
        return "¡Operación exitosa!";
    }
    
    @DeleteMapping ("personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "¡Borrado exitoso!";
    }
    @PutMapping ("personas/edit/{id}")
    public Persona editPersona(@PathVariable Long id,
                              @RequestParam("name") String newName,
                              @RequestParam("surname") String newSurname,
                              @RequestParam("img") String newImg){
        
        Persona persona = ipersonaService.findPersona(id);
        persona.setName(newName);
        persona.setSurname(newSurname);
        persona.setImg(newImg);
        
        ipersonaService.savePersona(persona);
        
        return persona;       
    }
    @GetMapping ("personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((Long)1);
    }
}
