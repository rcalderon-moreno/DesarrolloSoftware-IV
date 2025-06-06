
package com.example.composion.unoamuchos;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    
    private Integer idCurso;
    private String nombreCurso;
    private Integer semestre;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="programa_id", nullable=false)
    private Programa programa;

    public Curso() {
    }

    public Curso(String nombreCurso, Integer semestre, Programa programa) {
        this.nombreCurso = nombreCurso;
        this.semestre = semestre;
        this.programa = programa;
    }

    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", nombreCurso=" + nombreCurso + ", semestre=" + semestre + '}';
    }
    
    
}
