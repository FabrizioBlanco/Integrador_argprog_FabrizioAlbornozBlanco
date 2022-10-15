/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.integrador.Service;

import com.proyecto.integrador.Entity.Experiencia;
import com.proyecto.integrador.Repository.RepositoryExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceExperiencia {
    @Autowired
    RepositoryExperiencia rExperiencia;
    
    public List<Experiencia> list(){
    //armamos una lista con las experiencias
        return rExperiencia.findAll();    
    }
    
    public Optional<Experiencia> getOne(int id){//Es un método de JpaRepository, aun que dice que esta en desuso. 
        return rExperiencia.findById(id);
        
    }
    
    public Optional<Experiencia> findByNameE(String nombreExperiencia){
        return rExperiencia.findByNombreExperiencia(nombreExperiencia);
    }
    
    public void save(Experiencia experiencia){
        rExperiencia.save(experiencia);
    }
    
    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    
    
    public boolean existsById(int id){
       return rExperiencia.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rExperiencia.existsByNombreExperiencia(nombre);
    }
    
}
