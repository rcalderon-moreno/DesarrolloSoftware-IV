
package com.example.agregacion;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer idCliente;
    private String razonSocial;
    private String email;
    
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
    
    @JoinTable(
            name = "cliente_empresa",
            joinColumns = {@JoinColumn(name = "id_cliente")},
            inverseJoinColumns = {@JoinColumn(name = "id_empresa")}
    )
    
    
    
    private List<Empresa> empresas=new ArrayList<Empresa>();
    

    public Cliente(Integer idCliente, String razonSocial, String email) {
        this.idCliente = idCliente;
        this.razonSocial = razonSocial;
        this.email = email;
    }

    public Cliente() {
    }

    
    public void adicionarEmpresa(Empresa empresa){
    
        this.empresas.add(empresa);
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", razonSocial=" + razonSocial + ", email=" + email + '}';
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

   
    

   
   
    
    
    


    
    
}
