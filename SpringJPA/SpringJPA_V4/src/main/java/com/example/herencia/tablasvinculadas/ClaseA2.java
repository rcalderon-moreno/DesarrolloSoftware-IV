
package com.example.herencia.tablasvinculadas;

import jakarta.persistence.Entity;

@Entity
public class ClaseA2 extends ClaseA{
    private Integer valorClaseA2;

    public ClaseA2(Integer valorClaseA2, String texto) {
        super(texto);
        this.valorClaseA2 = valorClaseA2;
    }

    public ClaseA2() {
    }

    @Override
    public String toString() {
        return "ClaseA2{" + "valorClaseA2=" + valorClaseA2 + '}';
    }


    

    

}
