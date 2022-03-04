package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PedidoNotFoundExeption2 extends RuntimeException{

	/**
	 * Esta excepcion solo se deberia de ver cuando intentas sacar un pedido que no existe
	 */
	private static final long serialVersionUID = 7916770944724327571L;

	public PedidoNotFoundExeption2(Long id) {
		super("El pedido " + id + " no existe");
	}
}
