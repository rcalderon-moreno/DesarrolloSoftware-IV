
package com.example.herencia.tablasvinculadas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ClaseA {
    @Id
    @GeneratedValue
    private Integer idClase;
    private String texto;

    public ClaseA() {
    }

    public ClaseA(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "ClaseA{" + "id=" + idClase + ", texto=" + texto + '}';
    }
    
    
    
    
}
