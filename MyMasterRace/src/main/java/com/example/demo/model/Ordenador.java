package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.model.componentes.Disco;
import com.example.demo.model.componentes.Fuente;
import com.example.demo.model.componentes.Grafica;
import com.example.demo.model.componentes.Procesador;
import com.example.demo.model.componentes.Ram;
import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="ordenador")
public class Ordenador {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@ManyToOne
	private Ram ram;
	@ManyToOne
	private Procesador procesador;
	@ManyToOne
	private Disco discoduro;
	@ManyToOne
	private Grafica grafica;
	@ManyToOne
	private Fuente fuente;
	private String imagenes;
	private String descripcion;
	private double precio;
	@ManyToOne
	@JsonBackReference
	private User usuario;
	
	public Ordenador() {
		super();
	}
	
	public Ordenador(String nombre, Ram ram, Procesador procesador, Disco listadediscosduros, Grafica grafica,
			Fuente fuente, String imagenes, String descripcion, double precio, User usuario) {
		super();
		this.nombre = nombre;
		this.ram = ram;
		this.procesador = procesador;
		this.discoduro = listadediscosduros;
		this.grafica = grafica;
		this.fuente = fuente;
		this.imagenes = imagenes;
		this.descripcion = descripcion;
		this.precio = precio;
		this.usuario = usuario;
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

	public Ram getRam() {
		return ram;
	}


	public void setRam(Ram ram) {
		this.ram = ram;
	}


	public Procesador getProcesador() {
		return procesador;
	}


	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}


	public Disco getListadediscosduros() {
		return discoduro;
	}


	public void setListadediscosduros(Disco listadediscosduros) {
		this.discoduro = listadediscosduros;
	}


	public Grafica getGrafica() {
		return grafica;
	}


	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}


	public Fuente getFuente() {
		return fuente;
	}


	public void setFuente(Fuente fuente) {
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
