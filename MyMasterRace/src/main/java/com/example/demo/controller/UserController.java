package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.OrdenadorInexistenteNotFoundExeption;
import com.example.demo.error.ProcesadorNotFoundExeption;
import com.example.demo.error.SocketNotFoundExeption;
import com.example.demo.model.Ordenador;
import com.example.demo.model.User;
import com.example.demo.model.componentes.Procesador;
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
    	Ordenador result=serviceOrdenador.buscar(id);
    	
    	if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
    
    @GetMapping("/componente/procesador/{id}")
    public ResponseEntity<List<Procesador>> procesadoresCompatibles(@PathVariable Long id) {
    	List<Procesador> result=serviceProcesador.listarProcesadoresCompatibles(id);
    	if (serviceProcesador.buscarProcesador(id)==null) {
			throw new ProcesadorNotFoundExeption(id);
		}else {
	    	if (result==null) {
				throw new SocketNotFoundExeption(serviceProcesador.buscarProcesador(id).getSocket());
			}else {
		    	return ResponseEntity.ok(result);
			}
		}
    }
    
    @GetMapping("/componente/ram/{id}")
    public ResponseEntity<List<Procesador>> ramCompatibles(@PathVariable Long id) {
    	List<Procesador> result=serviceProcesador.listarProcesadoresCompatibles(id);
    	if (serviceProcesador.buscarProcesador(id)==null) {
			throw new ProcesadorNotFoundExeption(id);
		}else {
	    	if (result==null) {
				throw new SocketNotFoundExeption(serviceProcesador.buscarProcesador(id).getSocket());
			}else {
		    	return ResponseEntity.ok(result);
			}
		}
    }
    
    @GetMapping("/componente/discos")
    public ResponseEntity<List<Procesador>> discos() {
    	return null;
    }
    
    @GetMapping("/componente/Graficas")
    public ResponseEntity<List<Procesador>> graficas() {
    	return null;
    }
    
    @GetMapping("/componente/fuentes")
    public ResponseEntity<List<Procesador>> fuenetes() {
    	return null;
    }

    @GetMapping("/consultaRapida")
    public ResponseEntity<String> pedidoRapido() {
    	return ResponseEntity.ok("funciona");
    }
}