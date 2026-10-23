package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.EmpleadoRequestDTO;
import com.example.demo.dto.EmpleadoResponseDTO;

public interface EmpleadoService {

	EmpleadoResponseDTO guardar(EmpleadoRequestDTO request);
	EmpleadoResponseDTO actualizar(Long id, EmpleadoRequestDTO request);
	void eliminar(Long id);
	
	EmpleadoResponseDTO buscarId(Long id);
	List<EmpleadoResponseDTO> listar(); 
}
