package com.springboot.tienda.app.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vendedores")
public class Vendedor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellido;

	@NotEmpty
	private String rut;

	private String fecha_nac;

	private String email;

	// Constructor
	public Vendedor() {
	}

	public Vendedor(int id, @NotEmpty String nombre, @NotEmpty String apellido, @NotEmpty String rut, String fecha_nac,
			String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.fecha_nac = fecha_nac;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private static final long serialVersionUID = 1L;

}
