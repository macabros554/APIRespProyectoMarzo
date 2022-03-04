package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GraficaNotFoundExeption extends RuntimeException{
	/**
	 * Esta excepcion solo se deberia de ver cuando no existe una grafica con la id introducida
	 */
	private static final long serialVersionUID = -5678062630182539729L;

	public GraficaNotFoundExeption(Long id) {
		super("No se puede encontrar la grafica con ID: "+ id);
	}
}
