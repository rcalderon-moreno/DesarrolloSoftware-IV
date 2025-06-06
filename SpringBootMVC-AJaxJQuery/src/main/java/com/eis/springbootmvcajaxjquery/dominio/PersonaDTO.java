
package com.eis.springbootmvcajaxjquery.dominio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class PersonaDTO {
    public String nombres;
    public String apellidos;

     public PersonaDTO(@Value("NombresPersona")  String nombres, @Value("ApellidoPersona")  String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
     
    @Override
    public String toString() {
        return "PersonaDTO{" + "nombres=" + nombres + ", apellidos=" + apellidos + '}';
    }
    
    
    
}
