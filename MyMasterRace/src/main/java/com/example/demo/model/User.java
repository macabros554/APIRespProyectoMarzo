package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class User {

	
	private String name;
	@Id
	private String email;
	private String calle;
	private String telefono;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String tipopado;
	private String codigotarjeta;
	private String tarjeta;
	private String dueniotarjeta;
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	private List<Pedido> listapedidos=new ArrayList<>();
	
	public User() {
		super();
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public User(String name, String email, String calle, String telefono, String password) {
		super();
		this.name = name;
		this.email = email;
		this.calle = calle;
		this.telefono = telefono;
		this.password = password;
	}
	
	

	public User(String name, String email, String calle, String telefono, String password, String tipopado,
			String codigotarjeta, String tarjeta, String dueniotarjeta) {
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

	public List<Pedido> getListapedidos() {
		return listapedidos;
	}

	public void setListapedidos(List<Pedido> listapedidos) {
		this.listapedidos = listapedidos;
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
				+ ", tarjeta=" + tarjeta + ", dueniotarjeta=" + dueniotarjeta + ", fechanacimiento="
				+ "]";
	}
	
	
	
	
}
