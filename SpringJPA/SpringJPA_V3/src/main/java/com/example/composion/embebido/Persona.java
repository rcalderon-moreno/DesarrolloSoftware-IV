
package com.example.composion.embebido;
import com.example.composion.embebido.Color;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer idPersona;
    
    @Column(name="nombres", length=50)
    protected String nombres;
    
    @Column(name="apellidos", length=50)
    protected String apellidos;

    
    
    @Embedded    
    private Color color;

    public Persona() {
    }

    public Persona(String nombres, String apellidos,Color color) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.color=color;
    }

   
    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombres=" + nombres + ", apellidos=" + apellidos + ", color=" + color + '}';
    }
    
   

  
     
}
