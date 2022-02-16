package com.example.demo.model.componentes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ram")
public class Ram {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nombre;
    private String tipo; // DDR4 DDR3 ...
    private String formato; //DIMM o SO-DIMM
    private String capacidad;
    private String kit;
    private double precio;
    
	public Ram() {
		super();
	}

	public Ram(String nombre, String tipo, String formato, String capacidad, String kit, double precio) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.formato = formato;
		this.capacidad = capacidad;
		this.kit = kit;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}
	
	public String getKit() {
		return kit;
	}

	public void setKit(String kit) {
		this.kit = kit;
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
		Ram other = (Ram) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Ram [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", formato=" + formato + ", capacidad="
				+ capacidad + ", kit=" + kit + ", precio=" + precio + "]";
	}

}
