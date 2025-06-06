
package com.example.ejemplos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="MiClaseB")
public class ClaseB {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String texto;
    private String datos[]= {"A","B","C"};
    
    
    public ClaseB() {
        this.texto="...texto...";                
    }

    @Override
    public String toString() {
        return "ClaseB{" + "id=" + id + ", texto=" + texto + ", datos=" + Arrays.toString(datos) + '}';
    }
    
}
