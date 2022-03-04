package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FuenteNotFoundExeption extends RuntimeException{

	/**
	 * Esta excepcion solo se deberia de ver cuando no existe una fuente con la id introducida
	 */
	private static final long serialVersionUID = -7555320173876566180L;

	public FuenteNotFoundExeption(Long id) {
		super("No se puede encontrar la fuente con ID: "+ id);
	}
}
