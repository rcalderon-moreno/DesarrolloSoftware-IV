
package com.example.herencia.unatabla;

import jakarta.persistence.Entity;

@Entity
public class ClaseEspecializadaB  extends ClaseBase {
    
    private String reporte;

    public ClaseEspecializadaB() {
    }

    public ClaseEspecializadaB(String reporte, String nombre) {
        super(nombre);
        this.reporte = reporte;
    }

    @Override
    public String toString() {
        return "ClaseEspecializadaB{" + "reporte=" + reporte + '}';
    }
    
    
            
}
