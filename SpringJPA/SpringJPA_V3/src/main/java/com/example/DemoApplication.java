package com.example;

import com.example.agregacion.Cliente;
import com.example.agregacion.ClienteDAO;
import com.example.agregacion.Empresa;
import com.example.agregacion.EmpresaDAO;
import com.example.composion.embebido.Color;
import com.example.composion.unoamuchos.Curso;
import com.example.composion.embebido.Persona;
import com.example.composion.embebido.PersonaDAO;
import com.example.composion.unoamuchos.Programa;
import com.example.composion.unoamuchos.ProgramaDAO;
import com.example.composion.embebido.Usuario;
import com.example.composion.embebido.UsuarioDAO;
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
      private ProgramaDAO programaDAO;
      
      @Autowired
      private UsuarioDAO usuarioDAO;

      @Autowired
      private PersonaDAO personaDAO;      

      @Autowired
      private Color color;  
      
      @Autowired
      private EstudianteDAO estudianteDAO;    
      
      @Autowired
      private EmpresaDAO empresaDAO;      
      
      @Autowired
      private ClienteDAO clienteDAO;      
      
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
      
    public void muchosAmuchos(){
    
        Empresa empresa=new Empresa("Unillanos");
        Empresa empresa2=new Empresa("SENA");
        
        
        Cliente cliente=new Cliente(1,"Pedro", "pedro@email.com");        
        
        
        cliente.adicionarEmpresa(empresa);                        
        clienteDAO.save(cliente);
        empresa.adicionarCliente(cliente);
        
        cliente=new Cliente(2,"Sandra", "sandra@email.com");        
        cliente.adicionarEmpresa(empresa);                
        clienteDAO.save(cliente);
        empresa.adicionarCliente(cliente);
                
        empresaDAO.save(empresa);
        
        
        Cliente cliente3=new Cliente(3,"Andres", "andres@email.com");                
        cliente3.adicionarEmpresa(empresa2);                
        clienteDAO.save(cliente3);        
        empresa2.adicionarCliente(cliente3);        
        
        empresaDAO.save(empresa2);
        
        
        
        Optional<Empresa> informaacionEmpresa= empresaDAO.findById(1);    
        cadenaLog.info("persona idEmpresa (1)-->" + informaacionEmpresa.toString()); 
        
        
        cadenaLog.info("-------------------------------");
        cadenaLog.info("Todas las empresas:");
        cadenaLog.info("-------------------------------");
        empresaDAO.findAll().forEach(p -> {
           cadenaLog.info(p.toString() + " * " +  p.getClientes().toString() );           
        });
        
        
        
        clienteDAO.findAll().forEach(p -> {
           cadenaLog.info(p.toString() );           
        });             
        
    }
    
    @Override
    public void run(String... args) throws Exception {
        
        cadenaLog.info("-------------------------------");
        this.unoAuno();
        cadenaLog.info("-------------------------------");
    }

}
