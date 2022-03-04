package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RamNotFoundExeption extends RuntimeException{

	/**
	 * Esta excepcion solo se deberia de ver cuando no existe una RAM con la id introducida
	 */
	private static final long serialVersionUID = 4358256116769035539L;

	public RamNotFoundExeption(Long id) {
		super("No se puede encontrar la ram con id: " + id);
	}
}
