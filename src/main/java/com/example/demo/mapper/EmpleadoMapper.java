package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.EmpleadoRequestDTO;
import com.example.demo.dto.EmpleadoResponseDTO;
import com.example.demo.entity.Empleado;

@Component
public class EmpleadoMapper {

	public Empleado toEntity(EmpleadoRequestDTO dtoRequest) {

		Empleado empleado = new Empleado();

		empleado.setId(dtoRequest.getId());
		empleado.setNombre(dtoRequest.getNombre());
		empleado.setApp(dtoRequest.getApp());
		empleado.setEdad(dtoRequest.getEdad());
		empleado.setCorreo(dtoRequest.getCorreo());
		empleado.setDepto(dtoRequest.getDepto());
		empleado.setSueldo(dtoRequest.getSueldo());

		return empleado;
	}

	public EmpleadoResponseDTO toResponseDTO(Empleado empleado) {

		EmpleadoResponseDTO response = new EmpleadoResponseDTO();

		response.setId(empleado.getId());
		response.setNombre(empleado.getNombre());
		response.setApp(empleado.getApp());
		response.setEdad(empleado.getEdad());
		response.setCorreo(empleado.getCorreo());
		response.setDepto(empleado.getDepto());
		response.setSueldo(empleado.getSueldo());

		return response;
	}
	
	

}
