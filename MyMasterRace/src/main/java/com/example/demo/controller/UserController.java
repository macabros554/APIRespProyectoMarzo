package com.example.demo.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.ApiError;
import com.example.demo.error.DiscoNotFoundExeption;
import com.example.demo.error.FuenteNotFoundExeption;
import com.example.demo.error.GraficaNotFoundExeption;
import com.example.demo.error.ListaPedidosNotFoundExeption;
import com.example.demo.error.OrdenadorIncompletoFoundExeption;
import com.example.demo.error.OrdenadorInexistenteNotFoundExeption;
import com.example.demo.error.PedidoNotFoundExeption;
import com.example.demo.error.PedidoReferenceNotFoundExeption;
import com.example.demo.error.PedidoUsuarioNotFoundExeption;
import com.example.demo.error.ProcesadorNotFoundExeption;
import com.example.demo.error.RamNotFoundExeption;
import com.example.demo.error.SocketNotFoundExeption;
import com.example.demo.error.UserNotFoundExeption;
import com.example.demo.model.Ordenador;
import com.example.demo.model.OrdenadorVendido;
import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoDTO;
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
import com.example.demo.service.OrdenadorVendidoService;
import com.example.demo.service.PedidoService;
import com.example.demo.service.ProcesadorService;
import com.example.demo.service.RamService;
import com.example.demo.service.UsuarioService;


@RestController
public class UserController {
    
	@Autowired
	private OrdenadorService serviceOrdenador;
	
	@Autowired
	private OrdenadorVendidoService serviceOrdenadorvendido;
    
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
	
	/**
	 * Metodo para sacar la lista completa de ordenadores guardados en la base de datos
	 * @return lista de ordenadores
	 */
    
    @GetMapping("/ordenador/listaOrdenadores")
    public ResponseEntity<List<Ordenador>> sacarOrdenadores() {
    	return ResponseEntity.ok(serviceOrdenador.findAll());
    }
    
    /**
     * Saca el ordenador que le pidas por la id
     * El ordenador que saca es de los que estan en venta no de los usuarios
     * @param id
     * @return ordenador
     */
    
    @GetMapping("/ordenador/{id}")
    public ResponseEntity<Ordenador> sacarUnOrdenador(@PathVariable Long id) {
    	Ordenador result=serviceOrdenador.buscar(id);
    	
    	if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
    
    /**
     * Saca el ordenador del cliente del pedido que le pases por la id
     * @param id
     * @return ordenador
     */
    
    @GetMapping("pedido/{id}/ordenadornuevo")
    public ResponseEntity<OrdenadorVendido> sacarOrdenadorDePedido(@PathVariable Long id) {
    	OrdenadorVendido result=servicePedido.buscarPedido(id).getOrdenador();
    	
    	if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
    
    /**
     * Saca los procesadore compatibles con ese ordenador apartir de la id del procesador que le pases
     * @param id
     * @return lista de procesadores
     */
    
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
    
    /**
     * Saca las RAMs compatibles con ese ordenador apartir de la id del la RAM que le pases
     * @param id
     * @return lista de RAMs
     */
    
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
    
    /**
     * Comprueba si el disco duro que le pasas existe y si existe pasa todos los discos duros del servidor
     * Mi verdad antes que pasaba la id del disco para que no pase ese disco en la peticion tenia sentido ahora no tanto
     * Ahora mismo conserva la id para que la ruta en el securitiConfig sea para todos los componentes => componentes/../..
     * @param id
     * @return lista de discos duros
     */
    
    @GetMapping("/componente/discos/{id}")
    public ResponseEntity<List<Disco>> discos(@PathVariable Long id) {
       	if (serviceDisco.buscarDisco(id)==null) {
			throw new DiscoNotFoundExeption(id);
		}else {
	    	List<Disco> result=serviceDisco.findAllDiscos(id);
	    	return ResponseEntity.ok(result);
		}

    }
    
    /**
     * Comprueba si la grafica que le pasas existe y si existe pasa todas las graficas del servidor
     * @param id
     * @return lista de graficas
     */
    
    @GetMapping("/componente/graficas/{id}")
    public ResponseEntity<List<Grafica>> graficas(@PathVariable Long id) {
       	if (serviceGrafica.buscarGrafica(id)==null) {
			throw new GraficaNotFoundExeption(id);
		}else {
	    	List<Grafica> result=serviceGrafica.findAllGraficas(id);
	    	return ResponseEntity.ok(result);
		}
    }
    
    /**
     * Comprueba si la fuente que le pasas existe y si existe pasa todas las fuentes del servidor
     * @param id
     * @return lista de graficas
     */
    
    @GetMapping("/componente/fuentes/{id}")
    public ResponseEntity<List<Fuente>> fuenetes(@PathVariable Long id) {
       	if (serviceFuente.buscarFuente(id)==null) {
			throw new FuenteNotFoundExeption(id);
		}else {
			List<Fuente> result=serviceFuente.findAllFuentes(id);
			return ResponseEntity.ok(result);
		}
    }
    
    /**
     * Crea el pedido que le pases siempre que no tenga un ordenador ni tenga campos vacios 
     * @param p
     * @return pedido
     */
    
    @PostMapping("/pedido")
    public ResponseEntity<Pedido> crearPedido(@RequestBody PedidoDTO p) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        Pedido pedido=servicePedido.crearPedidoSinOrdendor(p,serviceUsuario.buscarUsuario(email));
        
        if(pedido==null) {
        	throw new PedidoNotFoundExeption();
        }else {
        	return ResponseEntity.ok(pedido);
        }
    }
    
    /**
     * Saca el pedido que le pidas por la id mientras exista en la base de datos
     * @param id
     * @return
     */
    
    @GetMapping("/pedido/{id}")
    public ResponseEntity<Pedido> mostrarPedido(@PathVariable Long id) {
       	Pedido resp=servicePedido.buscarPedido(id);
    	
        if(resp==null) {
        	throw new PedidoNotFoundExeption();
        }else {
        	return ResponseEntity.ok(resp);
        }
    }
    
    /**
     * Modifica el pedido que le digas por la id con los datos que le envies del pedido
     * @param id
     * @param pedido
     * @return
     */
    
    @PutMapping("/pedido/{id}")
    public ResponseEntity<Pedido> mmodificarPedido(@PathVariable Long id,@RequestBody PedidoDTO pedido) {
       	Pedido resp=servicePedido.buscarPedido(id);
    	
        if(resp==null) {
        	throw new PedidoNotFoundExeption();
        }else {
        	resp=servicePedido.modificarPedido(id, pedido);
        	return ResponseEntity.ok(resp);
        }
    }
    
    /**
     * Devuelve la lista de pedidos del usuario sacando el usuario del token
     * @return
     */
    
    @GetMapping("/pedido")
    public ResponseEntity<List<Pedido>> mostrarPedidosUsuario() {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       	List<Pedido> resp=servicePedido.pedidosDelUsuario(serviceUsuario.buscarUsuario(email));
    	
        if(resp==null) {
        	throw new ListaPedidosNotFoundExeption();
        }else {
        	return ResponseEntity.ok(resp);
        }
    }
    
    /**
     * Borra el pedido que le pases pir la id, si el usuario no tiene ese pedido no lo borrara
     * @param id
     * @return
     */
    
    @DeleteMapping("/pedido/{id}")
    public ResponseEntity<Pedido> BorrarPedido(@PathVariable Long id) {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User usuario=serviceUsuario.buscarUsuario(email);
    	
        if(servicePedido.buscarPedido(id)==null) {
        	throw new PedidoNotFoundExeption();
        }else {
        	if(servicePedido.comprobarPedido(usuario,id)==false) {
        		throw new PedidoUsuarioNotFoundExeption(id,email);
        	}else {
        		serviceUsuario.borrarPedido(id,email);
        		return ResponseEntity.ok(null);
        	}
        }
    }
    
    /**
     * Sacas los datos del usuario
     * saca el usuario del token
     * @return
     */
    
    @GetMapping("/usuario")
    public ResponseEntity<User> mostrarDatosUsuario() {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       	User resp=serviceUsuario.buscarUsuario(email);
    	
        if(resp==null) {
        	throw new UserNotFoundExeption(email);
        }else {
        	return ResponseEntity.ok(resp);
        }
    }
    
    /**
     * borra el usuario que le pase por la id
     * deberia hacer otro metodo para que el usuario pueda borrarse a si mismo
     * @param email
     * @return
     */
    
    @DeleteMapping("/usuario/{email}")
    public ResponseEntity<User> borrarUsuario(@PathVariable String email) {
       	User resp=serviceUsuario.buscarUsuario(email);
    	
        if(resp==null) {
        	throw new UserNotFoundExeption(email);
        }else {
        	serviceUsuario.borrarUsuario(email);
        	return ResponseEntity.ok(resp);
        }
    	
    }
    
    /**
     * modifica los datos del usuario con los datos que le envie por el body
     * @param u
     * @return
     */
    
    @PutMapping("/usuario")
    public ResponseEntity<User> modificarUsuario(@RequestBody User u) {
       	User resp=serviceUsuario.buscarUsuario(u.getEmail());
        if(resp==null) {
        	throw new UserNotFoundExeption(u.getEmail());
        }else {
        	resp=serviceUsuario.modificarUsuario(u);
        	return ResponseEntity.ok(resp);
        }
    }
    
    /**
     * crea un ordenador dentro del pedido que le pase por la id
     * @param id
     * @param o
     * @return
     */
    
    //añadir que confirme si el usuario tiene el pedido
    
    @PostMapping("pedido/{id}/ordenadornuevo")
    public ResponseEntity<OrdenadorVendido> crearOrdenadorNuevo(@PathVariable Long id,@RequestBody OrdenadorVendido o) {
    	OrdenadorVendido resp = o;
        
        if(resp==null) {
        	throw new OrdenadorIncompletoFoundExeption();
        }else {
        	resp= serviceOrdenadorvendido.anadirOrdenador(o,id);
        	return ResponseEntity.ok(resp);
        }
    }
    
    /**
     * modifica el ordenador que le pase por la id si el ordenador esta en el pedido que pase por la id
     * @param idPedido
     * @param idOrdenador
     * @param o
     * @return
     */
    
    @PutMapping("pedido/{idPedido}/ordenadornuevo/{idOrdenador}")
    public ResponseEntity<OrdenadorVendido> modificarOrdenadorNuevo(@PathVariable Long idPedido,@PathVariable Long idOrdenador,@RequestBody OrdenadorVendido o) {
    	OrdenadorVendido resp = o;
        
    	if(servicePedido.confirmarOrdenadorEnPedido(idPedido,idOrdenador)==null) {
        	throw new PedidoReferenceNotFoundExeption(idPedido,idOrdenador);
        }else {
            if(resp==null) {
            	throw new OrdenadorIncompletoFoundExeption();
            }else {
            	resp= serviceOrdenadorvendido.modificarOrdenador(o,idPedido);
            	return ResponseEntity.ok(resp);
            }
        }
    }
    
    /**
     * borra el ordenador si esta en el pedido que le pasas y si el ordenador existe
     * @param idPedido
     * @param idOrdenador
     * @return
     */
    
    @DeleteMapping("pedido/{idPedido}/ordenadornuevo/{idOrdenador}")
    public ResponseEntity<Ordenador> borrarOrdenadorNuevo(@PathVariable Long idPedido,@PathVariable Long idOrdenador) {
        
        if(servicePedido.confirmarOrdenadorEnPedido(idPedido,idOrdenador)==null) {
        	throw new PedidoReferenceNotFoundExeption(idPedido,idOrdenador);
        }else {
        	serviceOrdenadorvendido.borrarOrdenadorDePedido(idPedido);
        	return ResponseEntity.ok(null);
        }
    }
    
    /**
     * Crea un nuevo ordenador que se mostrara en la tienda
     * @param o
     * @return
     */
    
    @PostMapping("/ordenador")
    public ResponseEntity<Ordenador> crearOrdenador(@RequestBody Ordenador o) {
    	Ordenador resp = o;
        
        if(resp==null) {
        	throw new OrdenadorIncompletoFoundExeption();
        }else {
        	resp= serviceOrdenador.anadirOrdenador(o);
        	return ResponseEntity.ok(resp);
        }
    }
    
    /*
    
    @PutMapping("/ordenador")
    public ResponseEntity<Ordenador> modificarOrdenador(@RequestBody Ordenador o) {
    	Ordenador resp = o;
        
        if(resp==null) {
        	throw new OrdenadorIncompletoFoundExeption();
        }else {
        	resp= serviceOrdenador.anadirOrdenador(o);
        	return ResponseEntity.ok(resp);
        }
    }
    
    
    @DeleteMapping("/ordenador")
    public ResponseEntity<Ordenador> borrarOrdenador(@RequestBody Ordenador o) {
    	Ordenador resp = o;
        
        if(resp==null) {
        	throw new OrdenadorIncompletoFoundExeption();
        }else {
        	resp= serviceOrdenador.anadirOrdenador(o);
        	return ResponseEntity.ok(resp);
        }
    }
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * excepciones 
     * @param ex
     * @return
     * @throws Exception
     */
    
    @ExceptionHandler(PedidoReferenceNotFoundExeption.class)
    public ResponseEntity<ApiError> pedidoSinOrdenadorError(PedidoReferenceNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
    @ExceptionHandler(OrdenadorIncompletoFoundExeption.class)
    public ResponseEntity<ApiError> ordenadorIncompletoError(OrdenadorIncompletoFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
    
    @ExceptionHandler(ListaPedidosNotFoundExeption.class)
    public ResponseEntity<ApiError> ListaPedidosError(ListaPedidosNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
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