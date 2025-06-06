package com.example;

import com.example.herencia.tablaporobjeto.Circulo;
import com.example.herencia.tablaporobjeto.FiguraGeometrica;
import com.example.herencia.tablaporobjeto.FiguraGeometricaDAO;
import com.example.herencia.tablaporobjeto.Rectangulo;
import com.example.herencia.tablaporobjeto.Triangulo;
import com.example.herencia.tablasvinculadas.ClaseA;
import com.example.herencia.tablasvinculadas.ClaseA1;
import com.example.herencia.tablasvinculadas.ClaseA2;
import com.example.herencia.tablasvinculadas.ClaseADAO;
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
    
    @Autowired
    private ClaseADAO claseADAO;
    
    @Autowired
    private FiguraGeometricaDAO figuraGeometricaDAO;
   
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
        cadenaLog.info("Todos las ClaseBase:");
        cadenaLog.info("-------------------------------");
        claseBaseDAO.findAll().forEach(p -> {
           cadenaLog.info(p.toString());
        });
        cadenaLog.info("-------------------------------");
        
        
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
        
        
        cadenaLog.info("-------------------------------"); 
        
        FiguraGeometrica figuraGeometrica= new Circulo(4.0);
        Rectangulo rectangulo=new Rectangulo(10,5);
        Triangulo triangulo=new Triangulo(3,6);
        
        figuraGeometricaDAO.save(figuraGeometrica);
        figuraGeometricaDAO.save(rectangulo);
        figuraGeometricaDAO.save(triangulo);
        
        cadenaLog.info("-------------------------------");
        cadenaLog.info("Todos las Figuras:");
        cadenaLog.info("-------------------------------");
        figuraGeometricaDAO.findAll().forEach(p -> {
           cadenaLog.info(p.toString());
        });
        cadenaLog.info("-------------------------------");
    }

}
