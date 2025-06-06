package com.example;


import com.example.herencia.unatabla.ClaseBase;
import com.example.herencia.unatabla.ClaseBaseDAO;
import com.example.herencia.unatabla.ClaseEspecializadaA;
import com.example.herencia.unatabla.ClaseEspecializadaB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaV4Application  implements CommandLineRunner {
      
    private static Logger cadenaLog = LoggerFactory.getLogger(SpringJpaV4Application.class);       

    @Autowired
    private ClaseBaseDAO claseBaseDAO;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaV4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        cadenaLog.info("-------------------------------"); 
        
        ClaseEspecializadaA claseEspecializadaA= new ClaseEspecializadaA("Texto..........","claseEspecializadaA");
        ClaseBase claseEspecializadaB=new ClaseEspecializadaB("Información","claseEspecializadaB");
        ClaseBase claseBase=new ClaseBase("claseBase");
        
        claseBaseDAO.save(claseEspecializadaA);
        claseBaseDAO.save(claseEspecializadaB);
        claseBaseDAO.save(claseBase);
        
        cadenaLog.info("-------------------------------");
        cadenaLog.info("Todas las ClaseBase:");
        cadenaLog.info("-------------------------------");
        claseBaseDAO.findAll().forEach(p -> {
           cadenaLog.info(p.toString());
        });
        cadenaLog.info("-------------------------------");
        
    }

}
