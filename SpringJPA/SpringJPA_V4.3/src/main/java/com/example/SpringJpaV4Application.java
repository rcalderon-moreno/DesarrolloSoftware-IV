package com.example;


import com.example.herencia.tablasvinculadas.ClaseA;
import com.example.herencia.tablasvinculadas.ClaseA1;
import com.example.herencia.tablasvinculadas.ClaseA2;
import com.example.herencia.tablasvinculadas.ClaseADAO;
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
    private ClaseADAO claseADAO;
   
    public static void main(String[] args) {
        SpringApplication.run(SpringJpaV4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        cadenaLog.info("-------------------------------"); 
        ClaseA1 claseaA1= new ClaseA1("Texto..........","------" );
        ClaseA2 claseaA2= new ClaseA2(123,"------" );
        claseADAO.save(claseaA1);
        claseADAO.save(claseaA2);
        cadenaLog.info("-------------------------------");
        cadenaLog.info("Todos las ClaseA:");
        cadenaLog.info("-------------------------------");
        claseADAO.findAll().forEach(p -> {
           cadenaLog.info(p.toString());
        });
        cadenaLog.info("-------------------------------");        
    }
}
