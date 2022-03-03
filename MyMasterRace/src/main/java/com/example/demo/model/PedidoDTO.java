package com.example.demo.model;

public class PedidoDTO {
	
	private String direccion;
	private String telefono;
	private String correoElectronico;
	private String tipopago;
	private String codigotarjeta;
	private String tarjeta;
	private String dueniotarjeta;
	
	public PedidoDTO(String direccion, String telefono, String correoElectronico, String tipopago, String codigotarjeta,
			String tarjeta, String dueniotarjeta) {
		super();
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.tipopago = tipopago;
		this.codigotarjeta = codigotarjeta;
		this.tarjeta = tarjeta;
		this.dueniotarjeta = dueniotarjeta;
	}

	public PedidoDTO() {
		super();
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
	public String toString() {
		return "PedidoDTO [direccion=" + direccion + ", telefono=" + telefono
				+ ", correoElectronico=" + correoElectronico + ", tipopago=" + tipopago + ", codigotarjeta="
				+ codigotarjeta + ", tarjeta=" + tarjeta + ", dueniotarjeta=" + dueniotarjeta + "]";
	}


}
