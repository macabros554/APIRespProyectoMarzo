package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PedidoReferenceNotFoundExeption extends RuntimeException{



	/**
	 * 
	 */
	private static final long serialVersionUID = 9179884440057752959L;

	public PedidoReferenceNotFoundExeption(Long idP, Long idO) {
		super("El pedido "+ idP + " no existe o el pedido no tiene asociado el ordenador con id " + idO);
	}
}