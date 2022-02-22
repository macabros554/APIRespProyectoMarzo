package com.example.demo.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.ApiError;
import com.example.demo.error.DiscoNotFoundExeption;
import com.example.demo.error.FuenteNotFoundExeption;
import com.example.demo.error.GraficaNotFoundExeption;
import com.example.demo.error.OrdenadorInexistenteNotFoundExeption;
import com.example.demo.error.PedidoNotFoundExeption;
import com.example.demo.error.ProcesadorNotFoundExeption;
import com.example.demo.error.RamNotFoundExeption;
import com.example.demo.error.SocketNotFoundExeption;
import com.example.demo.error.UserNotFoundExeption;
import com.example.demo.model.Ordenador;
import com.example.demo.model.Pedido;
import com.example.demo.model.User;
import com.example.demo.model.componentes.Disco;
import com.example.demo.model.componentes.Fuente;
import com.example.demo.model.componentes.Grafica;
import com.example.demo.model.componentes.Procesador;
import com.example.demo.model.componentes.Ram;
import com.example.demo.service.DiscoService;
import com.example.demo.service.FuenteService;
import com.example.demo.service.GraficaService;
import com.example.demo.service.OrdenadorService;
import com.example.demo.service.PedidoService;
import com.example.demo.service.ProcesadorService;
import com.example.demo.service.RamService;
import com.example.demo.service.UsuarioService;


@RestController
public class UserController {
    
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
	
	@Autowired
	private UsuarioService serviceUsuario;
	
	@Autowired
	private PedidoService servicePedido;
    
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
    	if (serviceProcesador.buscarProcesador(id)==null) {
			throw new ProcesadorNotFoundExeption(id);
		}else {
			List<Procesador> result=serviceProcesador.listarProcesadoresCompatibles(id);
	    	if (result==null) {
				throw new SocketNotFoundExeption(serviceProcesador.buscarProcesador(id).getSocket());
			}else {
		    	return ResponseEntity.ok(result);
			}
		}
    }
    
    @GetMapping("/componente/ram/{id}")
    public ResponseEntity<List<Ram>> ramCompatibles(@PathVariable Long id) {
    	if (serviceRam.buscarRam(id)==null) {
			throw new ProcesadorNotFoundExeption(id);
		}else {
	    	List<Ram> result=serviceRam.listarRamsCompatibles(id);
	    	if (result==null) {
				throw new SocketNotFoundExeption(serviceProcesador.buscarProcesador(id).getSocket());
			}else {
		    	return ResponseEntity.ok(result);
			}
		}
    }
    
    @GetMapping("/componente/discos/{id}")
    public ResponseEntity<List<Disco>> discos(@PathVariable Long id) {
       	if (serviceDisco.buscarDisco(id)==null) {
			throw new DiscoNotFoundExeption(id);
		}else {
	    	List<Disco> result=serviceDisco.findAllDiscos(id);
	    	return ResponseEntity.ok(result);
		}

    }
    
    @GetMapping("/componente/graficas/{id}")
    public ResponseEntity<List<Grafica>> graficas(@PathVariable Long id) {
       	if (serviceGrafica.buscarGrafica(id)==null) {
			throw new GraficaNotFoundExeption(id);
		}else {
	    	List<Grafica> result=serviceGrafica.findAllGraficas(id);
	    	return ResponseEntity.ok(result);
		}

    }
    
    @GetMapping("/componente/fuentes/{id}")
    public ResponseEntity<List<Fuente>> fuenetes(@PathVariable Long id) {
       	if (serviceFuente.buscarFuente(id)==null) {
			throw new FuenteNotFoundExeption(id);
		}else {
			List<Fuente> result=serviceFuente.findAllFuentes(id);
			return ResponseEntity.ok(result);
		}
    }
    
    @PostMapping("/pedido")
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido p) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        p.setUsuario(serviceUsuario.buscarUsuario(email));
        
        if(servicePedido.crearPedido(p)==null) {
        	throw new PedidoNotFoundExeption();
        }else {
        	return ResponseEntity.ok(p);
        }
    }
    
    @GetMapping("/pedido/{id}")
    public ResponseEntity<Pedido> mostrarPedido(@PathVariable Long id) {
       	Pedido resp=servicePedido.buscarPedido(id);
    	
        if(resp==null) {
        	throw new PedidoNotFoundExeption();
        }else {
        	return ResponseEntity.ok(resp);
        }
    	
    }
    
    /*@GetMapping("/usuario}")
    public ResponseEntity<User> mostrarDatosUsuario() {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       	User resp=serviceUsuario.buscarUsuario(email);
    	
        if(resp==null) {
        	throw new UserNotFoundExeption(email);
        }else {
        	return ResponseEntity.ok(resp);
        }
    	
    }*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @ExceptionHandler(FuenteNotFoundExeption.class)
    public ResponseEntity<ApiError> FuentesError(FuenteNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
    @ExceptionHandler(GraficaNotFoundExeption.class)
    public ResponseEntity<ApiError> GraficasError(GraficaNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
    @ExceptionHandler(DiscoNotFoundExeption.class)
    public ResponseEntity<ApiError> DiscoError(DiscoNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
    @ExceptionHandler(OrdenadorInexistenteNotFoundExeption.class)
    public ResponseEntity<ApiError> OrdenadorError(OrdenadorInexistenteNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
    @ExceptionHandler(ProcesadorNotFoundExeption.class)
    public ResponseEntity<ApiError> ProcesadorError(ProcesadorNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
    @ExceptionHandler(RamNotFoundExeption.class)
    public ResponseEntity<ApiError> RamError(RamNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
    @ExceptionHandler(SocketNotFoundExeption.class)
    public ResponseEntity<ApiError> SocketError(SocketNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
    @ExceptionHandler(PedidoNotFoundExeption.class)
    public ResponseEntity<ApiError> PedidoError(PedidoNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
    @ExceptionHandler(UserNotFoundExeption.class)
    public ResponseEntity<ApiError> UserError(UserNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
}