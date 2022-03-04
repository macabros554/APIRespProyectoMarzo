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
				registry.addMapping("/validarToken").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//listaDeOrdenadores
				registry.addMapping("/ordenador/listaOrdenadores").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//añadir Ordenador
				registry.addMapping("/ordenador").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//ordenador
				registry.addMapping("/ordenador/{id}").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//procesadoresCompatibles
				registry.addMapping("/componente/procesador/{id}").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//ramsCompatibles
				registry.addMapping("/componente/ram/{id}").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//DiscosDuros
				registry.addMapping("/componente/discos/{id}").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Graficas
				registry.addMapping("/componente/graficas/{id}").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Fuentes
				registry.addMapping("/componente/fuentes/{id}").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Crear pedido
				registry.addMapping("/pedido").allowedOrigins("http://localhost:4200")
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "DELETE", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//leerPedido BorrarPedido
				registry.addMapping("/pedido/{id}").allowedOrigins("http://localhost:4200")
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT","DELETE", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("pedido/{idPedido}/ordenadornuevo/{idOrdenador}").allowedOrigins("http://localhost:4200")
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT","DELETE", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/pedido/{id}/ordenadornuevo").allowedOrigins("http://localhost:4200")
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT","DELETE", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//usuario
				registry.addMapping("/usuario").allowedOrigins("http://localhost:4200")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//borrar usuario
				registry.addMapping("/usuario/{email}").allowedOrigins("http://localhost:4200")
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT","DELETE", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
			}
		};
	}
}
