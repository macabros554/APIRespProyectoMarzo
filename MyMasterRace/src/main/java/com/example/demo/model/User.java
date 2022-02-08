package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class User {

	@Id
	private String name;
	private String email;
	private String calle;
	private String telefono;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String tipopado;
	private String codigotarjeta;
	private String tarjeta;
	private String dueniotarjeta;
	@OneToMany
	@JsonBackReference
	private List<Ordenador> listaordenadores=new ArrayList<>();
	private Date fechanacimiento;
	
	public User() {
		super();
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User(String name, String email, String calle, String telefono, String password, String tipopado,
			String codigotarjeta, String tarjeta, String dueniotarjeta, List<Ordenador> listaordenadores,
			Date fechanacimiento) {
		super();
		this.name = name;
		this.email = email;
		this.calle = calle;
		this.telefono = telefono;
		this.password = password;
		this.tipopado = tipopado;
		this.codigotarjeta = codigotarjeta;
		this.tarjeta = tarjeta;
		this.dueniotarjeta = dueniotarjeta;
		this.listaordenadores = listaordenadores;
		this.fechanacimiento = fechanacimiento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipopado() {
		return tipopado;
	}

	public void setTipopado(String tipopado) {
		this.tipopado = tipopado;
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

	public List<Ordenador> getListaordenadores() {
		return listaordenadores;
	}

	public void setListaordenadores(List<Ordenador> listaordenadores) {
		this.listaordenadores = listaordenadores;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Usuario [name=" + name + ", email=" + email + ", calle=" + calle + ", telefono=" + telefono
				+ ", password=" + password + ", tipopado=" + tipopado + ", codigotarjeta=" + codigotarjeta
				+ ", tarjeta=" + tarjeta + ", dueniotarjeta=" + dueniotarjeta + ", fechanacimiento=" + fechanacimiento
				+ "]";
	}
	
	
	
	
}
