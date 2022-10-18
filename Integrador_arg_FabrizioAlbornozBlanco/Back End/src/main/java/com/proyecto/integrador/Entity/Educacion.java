/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.integrador.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEduc;
    private String descripcionEduc;
    private String anos;

    public Educacion() {}

    public Educacion(String nombreEduc, String descripcionEduc, String anos) {
        this.nombreEduc = nombreEduc;
        this.descripcionEduc = descripcionEduc;
        this.anos = anos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEduc() {
        return nombreEduc;
    }

    public void setNombreEduc(String nombreEduc) {
        this.nombreEduc = nombreEduc;
    }

    public String getDescripcionEduc() {
        return descripcionEduc;
    }

    public void setDescripcionEduc(String descripcionEduc) {
        this.descripcionEduc = descripcionEduc;
    }

    public String getAnos() {
        return anos;
    }

    public void setAnos(String anos) {
        this.anos = anos;
    }
    
}

