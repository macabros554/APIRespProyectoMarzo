package com.example.demo.model;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@CreationTimestamp
	private Date fechaPack;
	private String direccion;
	private String telefono;
	private String correoElectronico;
	@ManyToOne
	@JsonBackReference
	private User usuario;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @OneToOne
	private Ordenador ordenador;
    
	public Pedido(Date fechaPack, String direccion, String telefono, String correoElectronico, User usuario,
			Ordenador ordenador) {
		super();
		this.fechaPack = fechaPack;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.usuario = usuario;
		this.ordenador = ordenador;
	}

	public Pedido() {
		super();
	}

	public Date getFechaPack() {
		return fechaPack;
	}

	public void setFechaPack(Date fechaPack) {
		this.fechaPack = fechaPack;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
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

	public Ordenador getOrdenador() {
		return ordenador;
	}

	public void setOrdenador(Ordenador ordenador) {
		this.ordenador = ordenador;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pedido [fechaPack=" + fechaPack + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", correoElectronico=" + correoElectronico + ", usuario=" + usuario + ", id=" + id + ", ordenador="
				+ ordenador + "]";
	}

	
    
    
}
