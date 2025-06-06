package com.example;


import com.example.composion.unoauno.Direccion;
import com.example.composion.unoauno.Estudiante;
import com.example.composion.unoauno.EstudianteDAO;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {
    
      private static Logger cadenaLog = LoggerFactory.getLogger(DemoApplication.class);           

     
      @Autowired
      private EstudianteDAO estudianteDAO;    
      
      
      public static void main(String[] args) {
              SpringApplication.run(DemoApplication.class, args);
      }

      
  
        
    public void unoAuno(){

        Direccion direccion = new Direccion("Calle 5 #21-21 Sur","villavicencio","meta");
        Estudiante estudiante=new Estudiante("sandra","linares");        
        
        
        direccion.setEstudiante(estudiante);
        estudiante.setDireccionDeContacto(direccion);
        
        estudianteDAO.save(estudiante);
        
        direccion = new Direccion("Carrera 5 #21-21 Norte","restrepo","meta");
        estudiante=new Estudiante("ricardo","parrado");        
        
        direccion.setEstudiante(estudiante);
        estudiante.setDireccionDeContacto(direccion);
        
        estudianteDAO.save(estudiante);

        cadenaLog.info("-------------------------------");
        cadenaLog.info("Todos los estudiantes:");
        cadenaLog.info("-------------------------------");
        estudianteDAO.findAll().forEach(p -> {
           cadenaLog.info(p.toString());
        });        
    }
    
    
    @Override
    public void run(String... args) throws Exception {
        
        cadenaLog.info("-------------------------------");
        this.unoAuno();
        cadenaLog.info("-------------------------------");
    }

}
