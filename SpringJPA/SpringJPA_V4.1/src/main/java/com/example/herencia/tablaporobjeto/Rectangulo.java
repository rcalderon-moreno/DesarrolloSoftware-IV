
package com.example.herencia.tablaporobjeto;

import jakarta.persistence.Entity;

@Entity
public class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;
    public Rectangulo(double base, double altura) {
        super("Rectángulo");
        this.base=base;
        this.altura=altura;
        this.areaFigura= Math.round(( this.area())*100.0)/100.0;
    }

    public Rectangulo() {
    }

    
    
    
    @Override
    public double area() {
        return this.base*this.altura ;
    }

    @Override
    public String toString() {
        return super.toString()  + " Rectangulo{" + "base=" + base + ", altura=" + altura + '}';
    }
    
}
