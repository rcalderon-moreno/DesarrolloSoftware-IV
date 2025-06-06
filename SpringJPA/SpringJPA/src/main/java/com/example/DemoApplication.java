package com.example;

import com.example.entidades.Persona;
import com.example.persistencia.IPersonaDAO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner  {
    private static Logger cadenaLog = LoggerFactory.getLogger(DemoApplication.class);
    @Autowired
    private IPersonaDAO iPersonaDAO;
    public static void main(String[] args) {
            SpringApplication.run(DemoApplication.class, args);
    }

     @Override
    public void run(String... args) throws Exception {
           cadenaLog.info("---Inicio---");
           Persona persona=new Persona("","");        
           cadenaLog.info("persona-->" + persona.toString());            
           persona.setApellidos("Morales");
           persona.setNombres("Juan");
          
           cadenaLog.info("persona-->" + persona.toString()); 
           
           iPersonaDAO.save(persona);           
           persona=new Persona("Sara","Rojas");   
           iPersonaDAO.save(persona);
           cadenaLog.info("persona-->" + persona.toString()); 
           persona=new Persona("Sara","Castro");   
           iPersonaDAO.save(persona);
           cadenaLog.info("persona-->" + persona.toString()); 
  
           cadenaLog.info("-------------------------------");
           cadenaLog.info("Todos las Personas con findAll():");
           cadenaLog.info("-------------------------------");
           iPersonaDAO.findAll().forEach(p -> {
              cadenaLog.info(p.toString());
           });
           
           cadenaLog.info("-------------------------------");
           cadenaLog.info("Persona con findByIdPersona():");
           cadenaLog.info("-------------------------------");
           persona=iPersonaDAO.findByIdPersona(1);
           cadenaLog.info("persona idPersona (1)-->" + persona.toString()); 
           
           cadenaLog.info("-------------------------------");
           cadenaLog.info("Persona con findByNombres():");
           cadenaLog.info("-------------------------------");
           
           iPersonaDAO.findByNombres("Sara").forEach(p -> {
              cadenaLog.info("persona nombres (Sara)-->" + p.toString()); 
           });           
        cadenaLog.info("---Fin---");
    }
}
