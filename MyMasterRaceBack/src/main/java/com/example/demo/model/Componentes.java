package com.example.demo.model;

import java.util.Objects;

public class Componentes {
	
	private Long id;
	private String tipo;
	private String generacion;
	private String nombre;
	private String cantidad;
	
	public Componentes(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Componentes(String tipo, String generacion, String nombre) {
		super();
		this.tipo = tipo;
		this.generacion = generacion;
		this.nombre = nombre;
	}
	
	public Componentes(String tipo, String generacion, String nombre, String cantidad) {
		super();
		this.tipo = tipo;
		this.generacion = generacion;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getGeneracion() {
		return generacion;
	}

	public void setGeneracion(String generacion) {
		this.generacion = generacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Componentes other = (Componentes) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Componentes [id=" + id + ", tipo=" + tipo + ", generacion=" + generacion + ", nombre=" + nombre
				+ ", cantidad=" + cantidad + "]";
	}
	
	
	
	

}
