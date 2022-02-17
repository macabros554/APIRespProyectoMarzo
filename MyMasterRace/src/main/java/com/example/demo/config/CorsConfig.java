package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//login
				registry.addMapping("/auth/login").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//register
				registry.addMapping("/auth/register").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//consultarToken
				registry.addMapping("/consultaRapida").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//listaDeOrdenadores
				registry.addMapping("/ordenador/listaOrdenadores").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//ordenador
				registry.addMapping("/ordenador/{id}/detalle").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//procesadoresCompatibles
				registry.addMapping("/componente/procesador/{id}").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
			}
		};
	}
}
