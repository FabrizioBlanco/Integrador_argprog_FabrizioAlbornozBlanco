package com.proyecto.integrador.Controller;

import com.proyecto.integrador.Dto.DtoExperiencia;
import com.proyecto.integrador.Entity.Experiencia;
import com.proyecto.integrador.Service.ServiceExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Experiencia Laboral")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerExperiencia {

    @Autowired
    ServiceExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        //una variable que contiene una lista
        List<Experiencia> list = sExperiencia.list();

        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreExperiencia())) {
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sExperiencia.existsByNombre(dtoExp.getNombreExperiencia())) {
            return new ResponseEntity<>(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(dtoExp.getNombreExperiencia(), dtoExp.getDescripcion());
        sExperiencia.save(experiencia);

        return new ResponseEntity<>(new Mensaje("Experiencia agregada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editExperiencia(@PathVariable("id") Integer id,
                                             @RequestBody DtoExperiencia dtoExperiencia) {

        if(!sExperiencia.existsById(id)){
            return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if(sExperiencia.existsByNombre(dtoExperiencia.getNombreExperiencia())
                                    && sExperiencia.findByNameE(dtoExperiencia.getNombreExperiencia()).get().getId() != id){
            return new ResponseEntity<>(new Mensaje("Esa experiencia ya fue previamente agregada"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoExperiencia.getNombreExperiencia())){
            return new ResponseEntity<>(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
        
        experiencia.setNombreExperiencia(dtoExperiencia.getNombreExperiencia());
        experiencia.setDescripcion(dtoExperiencia.getDescripcion());
        
        sExperiencia.save(experiencia);
        
        return new ResponseEntity<>(new Mensaje ("Experiencia actualizada"), HttpStatus.OK);
        
    }
}
