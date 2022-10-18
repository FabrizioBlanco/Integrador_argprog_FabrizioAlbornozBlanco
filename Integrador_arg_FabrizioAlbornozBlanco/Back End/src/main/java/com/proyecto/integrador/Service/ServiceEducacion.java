/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.integrador.Service;

import com.proyecto.integrador.Entity.Educacion;
import com.proyecto.integrador.Entity.Experiencia;
import com.proyecto.integrador.Repository.RepositoryEducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceEducacion {
    @Autowired
    RepositoryEducacion rEducacion;
    public List<Educacion> list(){
        return rEducacion.findAll();
    }
    public Optional<Educacion> getOne(int id){
         return rEducacion.findById(id);
     }
    
    public Optional<Educacion> getByNombreEduc(String nombreEduc){
        return rEducacion.findByNombreEduc(nombreEduc);
    }
    public void save(Educacion educacion){
        rEducacion.save(educacion);
    }
    public void delete(int id){
        rEducacion.deleteById(id);
    }
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    
    public boolean existsByNombrEduc(String nombreEduc){
        return rEducacion.existsByNombreEduc(nombreEduc);
    }
}
