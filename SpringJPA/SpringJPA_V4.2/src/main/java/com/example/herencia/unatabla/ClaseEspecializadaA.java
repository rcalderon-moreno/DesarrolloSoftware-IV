
package com.example.herencia.unatabla;

import jakarta.persistence.Entity;

@Entity
public class ClaseEspecializadaA extends ClaseBase {
    
    private String texto;

    public ClaseEspecializadaA() {
    }

    public ClaseEspecializadaA(String texto, String nombre) {
        super(nombre);
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "ClaseEspecializadaA{" + "texto=" + texto + '}';
    }
    
    
    
    
}
