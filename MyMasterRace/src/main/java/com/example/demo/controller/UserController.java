package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.OrdenadorNotFoundExeption;
import com.example.demo.model.Ordenador;
import com.example.demo.model.Pedido;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.DiscoService;
import com.example.demo.service.FuenteService;
import com.example.demo.service.GraficaService;
import com.example.demo.service.OrdenadorService;
import com.example.demo.service.ProcesadorService;
import com.example.demo.service.RamService;


@RestController
public class UserController {

    @Autowired private UserRepo userRepo;
    
	@Autowired
	private OrdenadorService serviceOrdenador;
    
	@Autowired
	private DiscoService serviceDisco;
	
	@Autowired
	private FuenteService serviceFuente;
	
	@Autowired
	private ProcesadorService serviceProcesador;
	
	@Autowired
	private RamService serviceRam;
	
	@Autowired
	private GraficaService serviceGrafica;

    @GetMapping("/user")
    public User getUserDetails(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepo.findByEmail(email).get();
    }
    
    @GetMapping("/ordenador/listaOrdenadores")
    public ResponseEntity<List<Ordenador>> sacarOrdenadores() {
    	return ResponseEntity.ok(serviceOrdenador.findAll());
    }
    
    @GetMapping("/ordenador/{id}/detalle")
    public ResponseEntity<Ordenador> sacarUnOrdenador(@PathVariable Long id) {
    	
    	return ResponseEntity.ok(serviceOrdenador.buscar(id));
    }

    @GetMapping("/consultaRapida")
    public ResponseEntity<String> pedidoRapido() {
    	return ResponseEntity.ok("funciona");
    }
}