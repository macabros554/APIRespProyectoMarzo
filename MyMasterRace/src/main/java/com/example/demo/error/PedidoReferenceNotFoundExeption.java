package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PedidoReferenceNotFoundExeption extends RuntimeException{



	/**
	 * 
	 */
	private static final long serialVersionUID = 377462690783142403L;

	public PedidoReferenceNotFoundExeption(Long idP) {
		super("El pedido "+ idP + " no existe o el pedido no tiene asociado un ordenador");
	}
}
