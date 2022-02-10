package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@SpringBootApplication
public class EjemploRestServiceJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjemploRestServiceJwtApplication.class, args);
	}
	@Autowired
	private PasswordEncoder codificador;
	
	@Bean
	CommandLineRunner iniUsuarios(UserRepo repoUsuario) {
		return (arg)-> {
			repoUsuario.save(new User("javi", "javi@gmail.com", "C/guadalpalo", "222444777", codificador.encode("javi")));
		};
	}

}
