package com.example.demo.model.componentes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fuente")
public class Fuente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nombre;
	private String certificacion;
	private String potencia;
	
	public Fuente() {
		super();
	}

	public Fuente(String nombre, String certificacion, String potencia) {
		super();
		this.nombre = nombre;
		this.certificacion = certificacion;
		this.potencia = potencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCertificacion() {
		return certificacion;
	}

	public void setCertificacion(String certificacion) {
		this.certificacion = certificacion;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fuente other = (Fuente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Fuente [id=" + id + ", nombre=" + nombre + ", certificacion=" + certificacion + ", potencia=" + potencia
				+ "]";
	}


	
	
}
