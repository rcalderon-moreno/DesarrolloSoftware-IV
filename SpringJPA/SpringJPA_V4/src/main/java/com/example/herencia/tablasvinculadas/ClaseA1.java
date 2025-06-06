
package com.example.herencia.tablasvinculadas;

import jakarta.persistence.Entity;

@Entity
public class ClaseA1 extends ClaseA{
    private String textoClaseA1;

    public ClaseA1(String textoClaseA1, String texto) {
        super(texto);
        this.textoClaseA1 = textoClaseA1;
    }

    public ClaseA1() {
    }

    @Override
    public String toString() {
        return "ClaseA1{" + "textoClaseA1=" + textoClaseA1 + '}';
    }


   
     
     
     
}
