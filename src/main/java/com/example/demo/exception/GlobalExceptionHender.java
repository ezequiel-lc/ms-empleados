package com.example.demo.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHender {

	// 400: Bad Request
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<HashMap<String, Object>> manejarValidacion(MethodArgumentNotValidException exponer) {

		HashMap<String, Object> Errores = new HashMap<>();
		exponer.getBindingResult().getFieldErrors()
				.forEach(error -> Errores.put(error.getField(), error.getDefaultMessage()));

		HashMap<String, Object> respuesta = new HashMap<>();
		respuesta.put("Success", false);
		respuesta.put("Message", "Error de validacion");
		respuesta.put("Data", Errores);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}

	// 404: Not Found
	@ExceptionHandler(EmpleadoNoEncontradoException.class)
	public ResponseEntity<HashMap<String, Object>> manejarEmpleadoNoEncontrado(EmpleadoNoEncontradoException exponer) {

		HashMap<String, Object> respuesta = new HashMap<>();
		respuesta.put("Success", false);
		respuesta.put("Menssage", exponer.getMessage());
		respuesta.put("Data", null);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	}

	// 409 CONFLICT
	@ExceptionHandler(InfoDuplicadaException.class)
	public ResponseEntity<HashMap<String, Object>> manejarEmpleadoDuplicado(InfoDuplicadaException exponer) {

		HashMap<String, Object> respuesta = new HashMap<>();
		respuesta.put("Success", false);
		respuesta.put("Message", exponer.getMessage());
		respuesta.put("Data", null);

		return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
	}

	// 500 Error interno del servidor - INTERNAL_SERVER_ERROR
	@ExceptionHandler(Exception.class)
	public ResponseEntity<HashMap<String, Object>> manejarErrorGeneral(Exception exponer) {

		HashMap<String, Object> respuesta = new HashMap<>();
		respuesta.put("Success", false);
		respuesta.put("Menssage", "Error interno en el Servidor");
		respuesta.put("Data", null);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
	}
	
	
}
