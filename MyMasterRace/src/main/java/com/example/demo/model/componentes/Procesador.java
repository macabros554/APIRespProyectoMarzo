package com.example.demo.model.componentes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="procesador")
public class Procesador {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nombre;
    private String marca;
    private String modelo;
    private String socket;
    private double precio;
    
	public Procesador() {
		super();
	}

	public Procesador(String nombre, String marca, String modelo, String socket, double precio) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.socket = socket;
		this.precio = precio;
	}

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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
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
		Procesador other = (Procesador) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Procesador [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", modelo=" + modelo + ", socket="
				+ socket + ", precio=" + precio + "]";
	}    

}
