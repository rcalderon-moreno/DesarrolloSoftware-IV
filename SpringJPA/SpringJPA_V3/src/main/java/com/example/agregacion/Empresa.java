
package com.example.agregacion;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer idEmpresa;
    private String nombreEmpresa;
    
    
    @ManyToMany(mappedBy = "empresas", fetch = FetchType.EAGER)
    private List<Cliente> clientes=new ArrayList<Cliente>();


    public Empresa(String nombreEmpresa) {        
        this.nombreEmpresa = nombreEmpresa;
    }

    public void adicionarCliente(Cliente cliente){
        this.clientes.add(cliente);
        cliente.getEmpresas().add(this);
        
    }
    
    public Empresa() {
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

 

    
    
    
    @Override
    public String toString() {
        return "Empresa{" + "idEmpresa=" + idEmpresa + ", nombreEmpresa=" + nombreEmpresa + '}';
    }
    
    
    
}
