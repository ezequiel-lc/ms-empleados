package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmpleadoRequestDTO;
import com.example.demo.dto.EmpleadoResponseDTO;
import com.example.demo.entity.Empleado;
import com.example.demo.exception.EmpleadoNoEncontradoException;
import com.example.demo.exception.InfoDuplicadaException;
import com.example.demo.mapper.EmpleadoMapper;
import com.example.demo.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImp implements EmpleadoService {
	
	private final EmpleadoRepository empleadoRepository; //metodos jparepository
	private final EmpleadoMapper empleadoMapper; //
	
	public EmpleadoServiceImp(EmpleadoRepository empleadoRepository, EmpleadoMapper empleadoMapper) {
		this.empleadoRepository = empleadoRepository;
		this.empleadoMapper = empleadoMapper;
	}
	
	
	@Override
	public EmpleadoResponseDTO guardar(EmpleadoRequestDTO request) {
		
		// throw new RuntimeException("Error de prueba");
		
		if(empleadoRepository.correoExiste(request.getCorreo())) {
			throw new InfoDuplicadaException("El correo ya existe en la BD " + request.getCorreo());
		}
		
		// solicitud -> entity
		Empleado empleado = empleadoMapper.toEntity(request);
		// guardar en oracle
		Empleado empleadoGuardado = empleadoRepository.save(empleado);
		
		// Empleado --> response
		return empleadoMapper.toResponseDTO(empleadoGuardado);
		
	}

	@Override
	public EmpleadoResponseDTO actualizar(Long id, EmpleadoRequestDTO request) {
		
		Empleado empleado = empleadoRepository.findById(id)
	            .orElseThrow(() -> new EmpleadoNoEncontradoException("Empleado no encontrado " + id));

	    empleado.setNombre(request.getNombre());
	    empleado.setApp(request.getApp());
	    empleado.setEdad(request.getEdad());
	    empleado.setCorreo(request.getCorreo());
	    empleado.setDepto(request.getDepto());
	    empleado.setSueldo(request.getSueldo());

	    Empleado empleadoActualizar = empleadoRepository.save(empleado);

	    return empleadoMapper.toResponseDTO(empleadoActualizar);
	}

	@Override
	public void eliminar(Long id) {
		if(!empleadoRepository.existsById(id)) {
			throw new EmpleadoNoEncontradoException("Empleado no encontrado con ID: " + id);
		}
		
		empleadoRepository.deleteById(id);
		
	}

	@Override
	public EmpleadoResponseDTO buscarId(Long id) {
		
		Empleado empleado = empleadoRepository.findById(id).orElseThrow(()-> new EmpleadoNoEncontradoException("Empleado no encontrado " + id));
		
		// entitity - responseDTO
		return empleadoMapper.toResponseDTO(empleado);
	}

	@Override
	public List<EmpleadoResponseDTO> listar() {
		
		return empleadoRepository.findAll().stream().map(empleadoMapper :: toResponseDTO).toList();
	}

}
