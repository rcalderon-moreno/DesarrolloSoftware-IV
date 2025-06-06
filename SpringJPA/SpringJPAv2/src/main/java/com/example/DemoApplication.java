package com.example;

import com.example.ejemplos.ClaseA;
import com.example.ejemplos.ClaseADAO;
import com.example.ejemplos.ClaseB;
import com.example.ejemplos.ClaseBDAO;
import com.example.ejemplos.ClaseC;
import com.example.ejemplos.ClaseCDAO;
import java.util.Optional;
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
    private ClaseADAO claseADAO;
    
    @Autowired
    private ClaseBDAO claseBDAO;
    
    @Autowired
    private ClaseCDAO claseCDAO;
    
    public static void main(String[] args) {
            SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        ClaseA claseA=new ClaseA();
        
        cadenaLog.info(claseA.metodoClaseA()); 
        cadenaLog.info("claseA-->" + claseA.toString());     
        
        claseADAO.save(claseA);
                
        claseA=new ClaseA();
        cadenaLog.info(claseA.metodoClaseA()); 
        cadenaLog.info("claseA-->" + claseA.toString());  
        
        claseADAO.save(claseA);
        
        
        
        cadenaLog.info("-------------------------------");
        cadenaLog.info("Todos las claseA con findAll():");
        cadenaLog.info("-------------------------------");
        claseADAO.findAll().forEach(p -> {
           cadenaLog.info(p.toString());
        });
        
        ClaseB claseB=new ClaseB();
        cadenaLog.info("claseB-->" + claseB.toString());          
        claseBDAO.save(claseB);        
        Optional<ClaseB> claseB2= claseBDAO.findById(1);        
        cadenaLog.info("persona idPersona (1)-->" + claseB2.toString());
        
        
        ClaseC claseC=new ClaseC();
        cadenaLog.info("claseC-->" + claseC.toString());        
        claseCDAO.save(claseC);
        Optional<ClaseC> claseC2= claseCDAO.findById(1);        
        cadenaLog.info("persona idPersona (1)-->" + claseC2.toString());
        
    }

}
