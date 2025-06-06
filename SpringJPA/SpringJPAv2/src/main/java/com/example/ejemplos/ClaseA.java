
package com.example.ejemplos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Calendar;
import org.springframework.stereotype.Component;

@Component
@Entity
public class ClaseA {
    @Id
   // @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    private Integer valor; 
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHora;
    @Enumerated(EnumType.STRING)
    private Estados estado;
    @Column(name="texto",length=250)
    private String  descripcion;

    public ClaseA() {
        this.valor=1;
        this.fechaHora = Calendar.getInstance();  
        this.descripcion="***********************************************";
        this.id= Long.toString(this.fechaHora.getTimeInMillis()) ;
        estado=Estados.INICIAL;
    }
    
    public String metodoClaseA(){
    
        return "...metodoClaseA()";
    }
    @Override
    public String toString() {
        return "ClaseA{" + "id=" + id + ", valor=" + valor + ", fechaHora=" + fechaHora.getTime() + ", estado=" + estado + ", descripcion=" + descripcion + '}';
    }
}
