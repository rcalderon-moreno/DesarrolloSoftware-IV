
package com.example.composion.embebido;


import jakarta.persistence.Embeddable;
import org.springframework.stereotype.Component;

@Component
@Embeddable
public class Color {
    private String nombreColor;
    private String codigoHexadecimal;

    public Color() {
        this.nombreColor = "rojo";
        this.codigoHexadecimal = " #ff3333";
    }

    @Override
    public String toString() {
        return "Color{" + "nombre=" + nombreColor + ", codigoHexadecimal=" + codigoHexadecimal + '}';
    }
}