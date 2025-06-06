package com.example;


import com.example.composion.embebido.Color;

import com.example.composion.embebido.Persona;
import com.example.composion.embebido.PersonaDAO;
import com.example.composion.embebido.Usuario;
import com.example.composion.embebido.UsuarioDAO;

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
      private UsuarioDAO usuarioDAO;

      @Autowired
      private PersonaDAO personaDAO;      

      @Autowired
      private Color color;  
      
      
      public static void main(String[] args) {
              SpringApplication.run(DemoApplication.class, args);
      }

      
    public void embebidos(){
        
        Set<String> listado = new HashSet<>();
        listado.add("3118341734");
        listado.add("3158341734");
        listado.add("3508341734");
        
        Usuario usuario=new Usuario("pedro",listado);
        
        usuarioDAO.save(usuario);

        cadenaLog.info("usuario-->" + usuario.toString());                     
        
        listado.clear();        
        listado.add("3008341734");
        listado.add("3018341734");
        usuario=new Usuario("juan",listado);
        
        usuarioDAO.save(usuario);
        cadenaLog.info("usuario-->" + usuario.toString());                     
        
        cadenaLog.info("-------------------------------");
        cadenaLog.info("Todos los usuarios:");
        cadenaLog.info("-------------------------------");
        usuarioDAO.findAll().forEach(p -> {
           cadenaLog.info(p.toString());
        });
        
        
        Persona persona =new Persona("juan","castro",color);
        personaDAO.save(persona);
        cadenaLog.info("usuario-->" + usuario.toString());                     
        persona =new Persona("felipe","moreno",color);
        personaDAO.save(persona);        
        cadenaLog.info("usuario-->" + usuario.toString());                     
        
        cadenaLog.info("-------------------------------");
        cadenaLog.info("Todos las personas:");
        cadenaLog.info("-------------------------------");
        personaDAO.findAll().forEach(p -> {
           cadenaLog.info(p.toString());
        });
        
    }
        
    
    @Override
    public void run(String... args) throws Exception {
        
        cadenaLog.info("-------------------------------");
        this.embebidos();
        cadenaLog.info("-------------------------------");
    }

}
