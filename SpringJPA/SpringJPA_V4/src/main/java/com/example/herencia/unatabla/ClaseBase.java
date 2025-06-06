
package com.example.herencia.unatabla;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ClaseBase {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;

    public ClaseBase() {
    }

    public ClaseBase(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ClaseBase{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
}
