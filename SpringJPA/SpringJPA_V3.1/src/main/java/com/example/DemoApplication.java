package com.example;

import com.example.agregacion.Cliente;
import com.example.agregacion.ClienteDAO;
import com.example.agregacion.Empresa;
import com.example.agregacion.EmpresaDAO;
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
      private EmpresaDAO empresaDAO;      
      
      @Autowired
      private ClienteDAO clienteDAO;      
      
      public static void main(String[] args) {
              SpringApplication.run(DemoApplication.class, args);
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
        this.muchosAmuchos();
        cadenaLog.info("-------------------------------");
    }

}
