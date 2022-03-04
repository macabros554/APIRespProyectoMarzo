package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TokenNoValidoExeption extends RuntimeException{

	/**
	 * Esta excepcion solo se deberia de ver cuando el token no es valido
	 */
	private static final long serialVersionUID = -7489496816287960240L;

	public TokenNoValidoExeption() {
		super("El token no es valido ");
	}
}
