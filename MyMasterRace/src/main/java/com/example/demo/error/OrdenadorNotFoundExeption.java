package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrdenadorNotFoundExeption extends RuntimeException{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6130141875730852227L;

	public OrdenadorNotFoundExeption() {
		super("No se puede generar el ordenador introducido ");
	}
}
