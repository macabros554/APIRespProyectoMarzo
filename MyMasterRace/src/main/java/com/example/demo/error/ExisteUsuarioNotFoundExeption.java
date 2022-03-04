package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExisteUsuarioNotFoundExeption extends RuntimeException{
	

	/**
	 * Esta excepcion solo se deberia de ver cuando el usuario que quiere registrarse usa un email que ya esta usando 
	 * otro usuario en la base de datos
	 */
	private static final long serialVersionUID = 690172232366359571L;

	public ExisteUsuarioNotFoundExeption() {
		super("El usuario ya existe");
	}
}
