
package com.example.composion.unoauno;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.List;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer codigo;
    private String nombres;
    private String apellidos;
    
    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)

    private Direccion direccionDeContacto;

    public Estudiante(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
       
    }

    public Estudiante() {
    }

   

    @Override
    public String toString() {
        return "Estudiante{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccionDeContacto=" + direccionDeContacto + '}';
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Direccion getDireccionDeContacto() {
        return direccionDeContacto;
    }

    public void setDireccionDeContacto(Direccion direccionDeContacto) {
        this.direccionDeContacto = direccionDeContacto;
    }

    
    
    
    
    
}
