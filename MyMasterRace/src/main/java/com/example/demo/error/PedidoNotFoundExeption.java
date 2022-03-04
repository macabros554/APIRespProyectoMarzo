package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PedidoNotFoundExeption extends RuntimeException{


	/**
	 * Esta excepcion solo se deberia de ver cuando intentas sacar los pedidos del usuario pero aun no tiene
	 */
	private static final long serialVersionUID = 7249817682006802176L;

	public PedidoNotFoundExeption() {
		super("El usuario no tiene pedidos");
	}
}
