package com.diego.sistemaweb.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.diego.sistemaweb.entitys.Ingreso;

public interface IngresoRepository extends JpaRepository<Ingreso, Long> {

}
