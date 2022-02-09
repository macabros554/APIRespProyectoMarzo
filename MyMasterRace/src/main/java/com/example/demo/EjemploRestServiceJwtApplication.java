package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@SpringBootApplication
public class EjemploRestServiceJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjemploRestServiceJwtApplication.class, args);
	}
	
	@Bean
	CommandLineRunner iniUsuarios(UserRepo repoUsuario) {
		return (arg)-> {
			repoUsuario.save(new User("javi", "javi@gmail.com", "C/guadalpalo", "222444777", "javi"));
		};
	}

}
