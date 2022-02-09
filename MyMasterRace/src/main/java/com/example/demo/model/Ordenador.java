package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="ordenador")
public class Ordenador {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String ram;
	private String procesador;
	private String listadediscosduros;
	private String grafica;
	private String fuente;
	private String imagenes;
	private String descripcion;
	private double precio;
	@ManyToOne
	@JsonBackReference
	private User usuario;
	
	
	public Ordenador(String nombre, String ram, String procesador, String grafica,
			String fuente, String descripcion, double precio) {
		super();
		this.nombre = nombre;
		this.ram = ram;
		this.procesador = procesador;
		this.grafica = grafica;
		this.fuente = fuente;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public User getUsuario() {
		return usuario;
	}


	public void setUsuario(User usuario) {
		this.usuario = usuario;
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


	public String getRam() {
		return ram;
	}


	public void setRam(String ram) {
		this.ram = ram;
	}


	public String getProcesador() {
		return procesador;
	}


	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}


	public String getListadediscosduros() {
		return listadediscosduros;
	}


	public void setListadediscosduros(String listadediscosduros) {
		this.listadediscosduros = listadediscosduros;
	}


	public String getGrafica() {
		return grafica;
	}


	public void setGrafica(String grafica) {
		this.grafica = grafica;
	}


	public String getFuente() {
		return fuente;
	}


	public void setFuente(String fuente) {
		this.fuente = fuente;
	}


	public String getImagenes() {
		return imagenes;
	}


	public void setImagenes(String imagenes) {
		this.imagenes = imagenes;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		Ordenador other = (Ordenador) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Ordenador [id=" + id + ", nombre=" + nombre + ", ram=" + ram + ", procesador=" + procesador
				+ ", grafica=" + grafica + ", fuente=" + fuente + ", descripcion=" + descripcion + ", precio=" + precio
				+ "]";
	}
	
	
	
	
	
	
	
}
