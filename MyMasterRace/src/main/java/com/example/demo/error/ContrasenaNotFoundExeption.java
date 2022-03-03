package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ContrasenaNotFoundExeption extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1983507434020502995L;

	public ContrasenaNotFoundExeption() {
		super("La contraseña no es valida ");
	}
}
