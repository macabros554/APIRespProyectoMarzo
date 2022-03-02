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
	private String tipopago;
	private String codigotarjeta;
	private String tarjeta;
	private String dueniotarjeta;
	@ManyToOne
	@JsonBackReference
	private User usuario;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @JsonBackReference
	@OneToOne
	private OrdenadorVendido ordenador;
    
	public Pedido(Long id) {
		super();
		this.id = id;
	}


	
	/*public Pedido(String direccion, String telefono, String correoElectronico, String tipopado, String codigotarjeta,
			String tarjeta, String dueniotarjeta, OrdenadorVendido ordenador) {
		super();
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.tipopago = tipopado;
		this.codigotarjeta = codigotarjeta;
		this.tarjeta = tarjeta;
		this.dueniotarjeta = dueniotarjeta;
		this.ordenador = ordenador;
	}*/



	public Pedido(String direccion, String telefono, String correoElectronico, String tipopado, String codigotarjeta,
			String tarjeta, String dueniotarjeta) {
		super();
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.tipopago = tipopado;
		this.codigotarjeta = codigotarjeta;
		this.tarjeta = tarjeta;
		this.dueniotarjeta = dueniotarjeta;
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

	public OrdenadorVendido getOrdenador() {
		return ordenador;
	}

	public void setOrdenador(OrdenadorVendido ordenador) {
		this.ordenador = ordenador;
	}

	public String getTipopago() {
		return tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}

	public String getCodigotarjeta() {
		return codigotarjeta;
	}

	public void setCodigotarjeta(String codigotarjeta) {
		this.codigotarjeta = codigotarjeta;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getDueniotarjeta() {
		return dueniotarjeta;
	}

	public void setDueniotarjeta(String dueniotarjeta) {
		this.dueniotarjeta = dueniotarjeta;
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
