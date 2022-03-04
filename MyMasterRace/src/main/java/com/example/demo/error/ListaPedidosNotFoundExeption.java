package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ListaPedidosNotFoundExeption extends RuntimeException{


	/**
	 * Esta excepcion solo se deberia de ver cuando se le introduce campos vacios al pedido
	 */
	private static final long serialVersionUID = 8668594047790173696L;

	public ListaPedidosNotFoundExeption() {
		super("El pedido tiene uno o mas valores vacios");
	}
}
