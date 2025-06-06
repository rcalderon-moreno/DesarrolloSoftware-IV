
package com.eis.springbootmvcajaxjquery.dominio;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Persona {

    private String nombres;
    private String apellidos;


    public Persona(@Value("NombresPersona")  String nombres, @Value("NombresPersona")  String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
        
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


   
    
    @Override
    public String toString() {
        return "Persona{" + "nombres=" + nombres + ", apellidos=" + apellidos + '}';
    }
}



//   public Persona() {
//       this.nombres = "nombres";
//       this.apellidos = "apellidos";
//    }
