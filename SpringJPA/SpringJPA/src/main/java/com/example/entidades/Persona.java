
package com.example.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Entity

public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer idPersona;
    @Column(name="nombres", length=50)
    protected String nombres;
    @Column(name="apellidos", length=50)
    protected String apellidos;

    public Persona() {
        this.nombres = "---";
        this.apellidos = "---";
    }

    public Persona(  String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        
        
        
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

 

    @Override
    public String toString() {
        return "Persona{" + "id=" + idPersona + ", nombres=" + nombres + ", apellidos=" + apellidos + '}';
    }
    
    
    
   
    
    
}