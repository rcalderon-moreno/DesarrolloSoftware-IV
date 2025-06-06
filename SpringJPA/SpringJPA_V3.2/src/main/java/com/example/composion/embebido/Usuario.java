
package com.example.composion.embebido;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Integer idUsuario;
    private String usuario;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="numerosTelefonicosUsuario", joinColumns=@JoinColumn(name="idUsuario"))
    @Column(name="numerosTelefonicos")
    private Set<String> numerosTelefonicos;

    public Usuario() {
    }

    public Usuario(String usuario, Set<String> numerosTelefonicos) {
        this.usuario = usuario;
        this.numerosTelefonicos = numerosTelefonicos;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idEmpleado=" + idUsuario + ", usuario=" + usuario + ", numerosTelefonicos=" + numerosTelefonicos + '}';
    }

    
    
    
    
    
}
