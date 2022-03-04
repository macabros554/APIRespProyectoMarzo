package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DiscoNotFoundExeption extends RuntimeException{

	/**
	 * Esta excepcion solo se deberia de ver cuando no existe un disco duro con la id introducida
	 */
	private static final long serialVersionUID = -2008283026892932404L;

	public DiscoNotFoundExeption(Long id) {
		super("No se puede encontrar el disco duro con ID: "+ id);
	}
}
