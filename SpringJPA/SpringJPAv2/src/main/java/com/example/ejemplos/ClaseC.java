
package com.example.ejemplos;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Transient;
import java.util.ArrayList;
import java.util.List;


@Entity
public class ClaseC {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Integer id;
    private String usuario;
    private List <String> datos;
    
    @Transient String atributoNoPersistente;

    public ClaseC() {
        this.usuario="juan";
        this.datos=new ArrayList(); 
        datos.add("d1");
        datos.add("d2");
        datos.add("d3");
        this.atributoNoPersistente="--No--";
    }

    @Override
    public String toString() {
        return "ClaseC{" + "id=" + id + ", usuario=" + usuario + ", datos=" + datos + ", atributoNoPersistente=" + atributoNoPersistente + '}';
    }

    
    
}
