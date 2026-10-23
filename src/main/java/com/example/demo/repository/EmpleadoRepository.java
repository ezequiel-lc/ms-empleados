package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Empleado;

import jakarta.transaction.Transactional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	
	boolean existsByCorreo(String correo);
	
	@Transactional
	@Query("SELECT COUNT(e) > 0 FROM Empleado e WHERE e.correo = :correo")
	boolean correoExiste(@Param("correo") String correo);

}
