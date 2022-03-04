package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PedidoReferenceNotFoundExeption extends RuntimeException{



	/**
	 * Esta excepcion solo se deberia de ver cuando el pedido no existe o el ordenador introducido no esta asociado a ese pedido
	 */
	private static final long serialVersionUID = 9179884440057752959L;

	public PedidoReferenceNotFoundExeption(Long idP, Long idO) {
		super("El pedido "+ idP + " no existe o el pedido no tiene asociado el ordenador con id " + idO);
	}
}
