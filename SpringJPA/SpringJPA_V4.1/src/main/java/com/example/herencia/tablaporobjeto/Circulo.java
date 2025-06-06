
package com.example.herencia.tablaporobjeto;

import jakarta.persistence.Entity;

@Entity
public class Circulo  extends FiguraGeometrica {

    private double radio;

    public Circulo(double radio) {
        super("Circulo");
        this.radio=radio;
        this.areaFigura= Math.round(( this.area())*100.0)/100.0;
    }

    public Circulo() {
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(this.radio,2);
    }

    @Override
    public String toString() {
        return super.toString() + " Circulo{" + "radio=" + radio + '}' ;
    }   
        
}


