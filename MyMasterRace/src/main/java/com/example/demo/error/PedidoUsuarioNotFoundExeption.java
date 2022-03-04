package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PedidoUsuarioNotFoundExeption extends RuntimeException{


	/**
	 * Esta excepcion solo se deberia de ver cuando el usuario no tiene el pedido introducido
	 */
	private static final long serialVersionUID = -5057115958129630205L;

	public PedidoUsuarioNotFoundExeption(Long id, String nombre) {
		super("El usuario "+ nombre + " no tiene el pedido con id: "+ id);
	}
}
