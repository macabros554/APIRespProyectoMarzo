package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SocketNotFoundExeption extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = -5438738551129565872L;

	public SocketNotFoundExeption(String id) {
		super("No tenemos procesadores con el socket : "+id);
	}
}
