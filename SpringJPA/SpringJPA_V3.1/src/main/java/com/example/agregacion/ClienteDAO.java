
package com.example.agregacion;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteDAO  extends JpaRepository<Cliente, Integer> {
    
}
