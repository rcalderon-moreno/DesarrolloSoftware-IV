/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.composion.unoauno;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Direccion {
   
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;


        private String direccion;
        private String municipio;
        private String departamento;

        @JoinColumn(name = "id_estudiante")
         @OneToOne(fetch = FetchType.LAZY)
        private Estudiante estudiante;

        public Direccion(String direccion, String municipio, String departamento) {
            this.direccion = direccion;
            this.municipio = municipio;
            this.departamento = departamento;            
    }

    public Direccion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

        
        
    @Override
    public String toString() {
        return "Direccion{" + "id=" + id + ", direccion=" + direccion + ", municipio=" + municipio + ", departamento=" + departamento + '}';
    }
    
    
}
