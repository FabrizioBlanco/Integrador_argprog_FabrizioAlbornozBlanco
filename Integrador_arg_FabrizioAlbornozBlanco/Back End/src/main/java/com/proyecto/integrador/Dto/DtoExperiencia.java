
package com.proyecto.integrador.Dto;

import javax.validation.constraints.NotBlank;


public class DtoExperiencia {
    
    
    @NotBlank
    private String nombreExperiencia;
    @NotBlank
    private String descripcion;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreExperiencia, String descripcion) {
        this.nombreExperiencia = nombreExperiencia;
        this.descripcion = descripcion;
    }

    public String getNombreExperiencia() {
        return nombreExperiencia;
    }

    public void setNombreExperiencia(String nombreExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
