package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrdenadorInexistenteNotFoundExeption extends RuntimeException{

	/**
	 * Esta excepcion solo se deberia de ver cuando intentas buscar un ordenador que no existe
	 */
	private static final long serialVersionUID = -6961015155150928005L;

	public OrdenadorInexistenteNotFoundExeption(Long id) {
		super("El ordenado con id: "+id+" no existe");
	}
}
