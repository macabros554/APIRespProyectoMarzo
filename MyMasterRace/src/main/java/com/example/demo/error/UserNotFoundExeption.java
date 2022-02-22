package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExeption extends RuntimeException{

	public UserNotFoundExeption(String id) {
		super("No se puede encontrar el usuario con email: "+ id);
	}
}
