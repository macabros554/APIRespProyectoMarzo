package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExeption extends RuntimeException{

	/**
	 * Esta excepcion solo se deberia de ver cuando el usuario que estas buscando no existe
	 */
	private static final long serialVersionUID = -1734935970367471063L;

	public UserNotFoundExeption(String id) {
		super("No se puede encontrar el usuario con email: "+ id);
	}
}
