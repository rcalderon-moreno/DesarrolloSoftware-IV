
package com.example.herencia.tablaporobjeto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class FiguraGeometrica {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;    
    protected double areaFigura;
    
    
    public abstract double area();
    
    public FiguraGeometrica(String nombre) {
        this.nombre = nombre;
        this.areaFigura=0;
    }

    public FiguraGeometrica() {
    }

    
   

    public String getNombre() {
        return nombre;
    }

    public double getAreaFigura() {
        return areaFigura;
    }  
  
    @Override
    public String toString() {
        return "FiguraGeometrica{" + "nombre=" + nombre + ", areaFigura=" + areaFigura + '}';
    }
    
}

