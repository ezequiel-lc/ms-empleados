package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpleadoRequestDTO;
import com.example.demo.dto.EmpleadoResponseDTO;
import com.example.demo.entity.Empleado;
import com.example.demo.service.EmpleadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Api/empleado")
@CrossOrigin
public class EmpleadoController {

	private final EmpleadoService empleadoService;
	
	public EmpleadoController(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}
	
	// http://localhost:9001/Api/empleado/listar
	@GetMapping("/listar")
	public ResponseEntity<List<EmpleadoResponseDTO>> listar(){
		return ResponseEntity.ok(empleadoService.listar());
	}
	
	// http://localhost:9001/Api/empleado/
	@GetMapping("/{id}")
	public ResponseEntity<EmpleadoResponseDTO> buscar(@PathVariable()long id){
		
		return ResponseEntity.ok(empleadoService.buscarId(id));
	}
	
	// http://localhost:9001/Api/empleado/guardar
	@PostMapping("/guardar")
	public ResponseEntity<EmpleadoResponseDTO> guardar(@Valid @RequestBody EmpleadoRequestDTO request){
		
		EmpleadoResponseDTO empleadoNuevo = empleadoService.guardar(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoNuevo);
	}
	
	// http://localhost:9001/Api/empleado/
	@PutMapping("/{id}")
	public ResponseEntity<EmpleadoResponseDTO> actualizar(@Valid @PathVariable()long id, @RequestBody EmpleadoRequestDTO request){
		EmpleadoResponseDTO empleadoActualizar = empleadoService.actualizar(id, request);
		return ResponseEntity.ok(empleadoActualizar);
	}
	
	// http://localhost:9001/Api/empleado/
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable()long id){
		empleadoService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
