package com.example;


import com.example.composion.unoamuchos.Curso;
import com.example.composion.unoamuchos.Programa;
import com.example.composion.unoamuchos.ProgramaDAO;

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
    private ProgramaDAO programaDAO;

    public static void main(String[] args) {
            SpringApplication.run(DemoApplication.class, args);
    }
    public void unoAmuchos(){
        
        Programa programa=new Programa("Ingeniería de Sistemas");                 
        
        programaDAO.save(programa);
        cadenaLog.info("programa-->" + programa.toString());    
        
        Programa programa2 =new Programa("Ingeniería Electrónica");        
        programaDAO.save(programa2);
        cadenaLog.info("programa-->" + programa2.toString());               
        
        
        Curso curso=new Curso("Programación",1,programa);                
        programa.adicionarCurso(curso);
        cadenaLog.info("curso-->" + curso.toString()); 
        
        curso=new Curso("Programación Orientada a Objetos",2,programa);                        
        programa.adicionarCurso(curso);        
        cadenaLog.info("curso-->" + curso.toString()); 
        
        programaDAO.save(programa);
        
        curso=new Curso("Fundamentos de Programación",1,programa2);
        programa2.adicionarCurso(curso);        
        programaDAO.save(programa2);
        cadenaLog.info("curso-->" + curso.toString()); 

        
        cadenaLog.info("-------------------------------");
        cadenaLog.info("Todos los programas:");
        cadenaLog.info("-------------------------------");
        programaDAO.findAll().forEach(p -> {
           cadenaLog.info(p.toString());
        });
    
    }
    
    @Override
    public void run(String... args) throws Exception {
        
        cadenaLog.info("-------------------------------");
        this.unoAmuchos();
        cadenaLog.info("-------------------------------");
    }

}
