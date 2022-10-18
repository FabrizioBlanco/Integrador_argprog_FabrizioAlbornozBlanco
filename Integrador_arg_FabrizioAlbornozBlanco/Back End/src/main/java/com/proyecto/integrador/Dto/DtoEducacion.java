/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.integrador.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author fabri
 */
public class DtoEducacion {
    @NotBlank
    private String nombreEduc;
    @NotBlank
    private String DescripcionEduc;
    @NotBlank
    private String anos;

    public DtoEducacion() {
    }

    public DtoEducacion(String nombreEduc, String DescripcionEduc, String anos) {
        this.nombreEduc = nombreEduc;
        this.DescripcionEduc = DescripcionEduc;
        this.anos = anos;
    }

    public String getNombreEduc() {
        return nombreEduc;
    }

    public void setNombreEduc(String nombreEduc) {
        this.nombreEduc = nombreEduc;
    }

    public String getDescripcionEduc() {
        return DescripcionEduc;
    }

    public void setDescripcionEduc(String DescripcionEduc) {
        this.DescripcionEduc = DescripcionEduc;
    }

    public String getAnos() {
        return anos;
    }

    public void setAnos(String anos) {
        this.anos = anos;
    }
    
    
}
