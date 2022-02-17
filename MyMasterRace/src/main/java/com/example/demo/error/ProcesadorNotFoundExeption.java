package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProcesadorNotFoundExeption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668345575635376335L;

	public ProcesadorNotFoundExeption(Long id) {
		super("No se a podido encontrar el procesador con id: "+id);
	}
}
