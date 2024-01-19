package com.diego.sistemaweb.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.sistemaweb.entitys.Egreso;

public interface EgresoRepository extends JpaRepository<Egreso, Long>{
    
}
