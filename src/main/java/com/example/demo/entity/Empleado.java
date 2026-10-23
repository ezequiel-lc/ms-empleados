package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "EMPLEADO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Empleado {
	
	@Id
	@Column(name="ID", columnDefinition = "NUMBER", nullable = false)
	private Long id;
	
	@Column(name="NOMBRE", columnDefinition = "VARCHAR2(50)", nullable = false, length = 50)
	private String nombre;
	
	@Column(name="APP", columnDefinition = "VARCHAR2(50)", nullable = false, length = 50)
	private String app;
	
	@Column(name="EDAD", columnDefinition = "NUMBER", nullable = false)
	private Integer edad;
	
	@Column(name="CORREO", columnDefinition = "VARCHAR2(50)", nullable = false, length = 50)
	private String correo;
	
	@Column(name="DEPTO", columnDefinition = "VARCHAR2(50)", nullable = false, length = 50)
	private String depto;
	
	@Column(name="SUELDO", columnDefinition = "NUMBER", nullable = false)
	private double sueldo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	
	
}
