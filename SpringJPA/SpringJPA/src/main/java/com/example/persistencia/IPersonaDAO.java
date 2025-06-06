
package com.example.persistencia;

import com.example.entidades.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPersonaDAO extends JpaRepository<Persona, Integer>  {
    
    List<Persona> findByNombres(String nombres);
    Persona findByIdPersona(Integer idPersona);
}
