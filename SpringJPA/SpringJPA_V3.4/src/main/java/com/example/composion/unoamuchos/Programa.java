
package com.example.composion.unoamuchos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="programas")
public class Programa {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer idPrograma;
    private String nombrePrograma;
    
    
    
    
    @OneToMany(mappedBy="programa", fetch = FetchType.EAGER, cascade = CascadeType.ALL)   
    
    private List<Curso> cursos = new ArrayList<>();

    public Programa() {
        
        
    }

    public Programa( String nombrePrograma) {
        this.idPrograma = idPrograma;
        this.nombrePrograma = nombrePrograma;
    }

    public void adicionarCurso(Curso curso){
        this.cursos.add(curso);
        
    }
    
    
    
    @Override
    public String toString() {
        return "Programa{" + "idPrograma=" + idPrograma + ", nombrePrograma=" + nombrePrograma + ", cursos=" + cursos.toString() + '}';
    }
    
    
    
}
