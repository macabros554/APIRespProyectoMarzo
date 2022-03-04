package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrdenadorVendido;
import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoDTO;
import com.example.demo.model.User;
import com.example.demo.repository.PedidoRepo;
import com.example.demo.repository.UserRepo;

@Service("pedido")
public class PedidoService {

	@Autowired
	private PedidoRepo repoPedido;
	
	@Autowired
	private UserRepo repoUsuario;
	
	@Autowired
	private OrdenadorVendidoService serviceOrdenadorVendido;
	
	/**
	 * crea el pedido que le pases en el usuario que le pases
	 * @param p
	 * @param usuario
	 * @return
	 */
	
	public Pedido crearPedidoSinOrdendor(PedidoDTO p, User usuario) {
		if (comprobarPedido(p)==false) {
			return null;
		}
		Pedido pedidoNuevo=new Pedido();
		repoPedido.save(pedidoNuevo);
		
		pedidoNuevo.setCorreoElectronico(p.getCorreoElectronico());
		pedidoNuevo.setDireccion(p.getDireccion());
		pedidoNuevo.setCodigotarjeta(p.getCodigotarjeta());
		pedidoNuevo.setTarjeta(p.getTarjeta());
		pedidoNuevo.setDueniotarjeta(p.getDueniotarjeta());
		pedidoNuevo.setTelefono(p.getTelefono());
		pedidoNuevo.setTipopago(p.getTipopago());
		pedidoNuevo.setUsuario(usuario);
		
		repoPedido.save(pedidoNuevo);
		
		anadirPedidoAlUsuario(pedidoNuevo.getUsuario().getEmail(),pedidoNuevo.getId());
		
		return pedidoNuevo;
	}
	
	/**
	 * añade el pedido que le pases al usuario que le pases
	 * @param email
	 * @param id
	 */
	
	private void anadirPedidoAlUsuario(String email,Long id) {
		User usuario=repoUsuario.findByEmail(email).orElse(null);
		Pedido pedido= repoPedido.findById(id).orElse(null);
		
		usuario.getListapedidos().add(pedido);
		repoUsuario.save(usuario);
		
	}
	
	/**
	 * añade el ordenador que le pases al pedido que le pases
	 * @param ordenador
	 * @param id
	 */
	
	public void anadirOrdenador(OrdenadorVendido ordenador,Long id) {
		Pedido pedido=repoPedido.findById(id).orElse(null);
		pedido.setOrdenador(ordenador);
		repoPedido.save(pedido);
	}
	
	/**
	 * comprobaciones para verificar que no envian un pedido con valores nulos
	 * @param p1
	 * @return
	 */
	
	public boolean comprobarPedido(PedidoDTO p1) {
		if(p1.getCorreoElectronico()==null || 
				p1.getDireccion()==null || 
				p1.getTelefono()==null || 
				p1.getCodigotarjeta()==null || 
				p1.getTarjeta()==null || 
				p1.getDueniotarjeta()==null || 
				p1.getTipopago() ==null ||
				p1.getCorreoElectronico().equals("") || 
				p1.getDireccion().equals("") || p1.getTelefono().equals("") ||
				p1.getCodigotarjeta().equals("") || p1.getTarjeta().equals("") || 
				p1.getTelefono().equals("") || p1.getTipopago().equals(""))	{
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * busca un pedido en la base de datos por su id y si no lo encuentra devuelve null
	 * @param id
	 * @return pedido
	 */
	
	public Pedido buscarPedido(Long id) {
		return repoPedido.findById(id).orElse(null);
	}
	
	/**
	 * confirma si el pedido tiene el ordenador que le pasas
	 * @param idPedido
	 * @param idOrdenador
	 * @return
	 */
	
	public Pedido confirmarOrdenadorEnPedido(Long idPedido,Long idOrdenador) {
		Pedido pedido= repoPedido.findById(idPedido).orElse(null);
		if(pedido.getOrdenador().getId()==idOrdenador) {
			return pedido;
		}else {
			return null;
		}
	}
	
	/**
	 * modifica el pedido con los datos no nulos que envies
	 * @param id
	 * @param p
	 * @return
	 */
	
	public Pedido modificarPedido(Long id, PedidoDTO p) {
		Pedido pedido=repoPedido.findById(id).orElse(null);
		
		if(p.getCodigotarjeta()==null || p.getCodigotarjeta().equals("")) {
			
		}else {
			pedido.setCodigotarjeta(p.getCodigotarjeta());
		}
		if(p.getCorreoElectronico()==null || p.getCorreoElectronico().equals("")) {
			
		}else {
			pedido.setCorreoElectronico(p.getCorreoElectronico());
		}
		if(p.getDireccion()==null || p.getDireccion().equals("")) {
			
		}else {
			pedido.setDireccion(p.getDireccion());
		}
		if(p.getDueniotarjeta()==null || p.getDueniotarjeta().equals("")) {
			
		}else {
			pedido.setDueniotarjeta(p.getDueniotarjeta());
		}
		if(p.getTarjeta()==null || p.getTarjeta().equals("")) {
			
		}else {
			pedido.setTarjeta(p.getTarjeta());
		}
		if(p.getTelefono()==null || p.getTelefono().equals("")) {
			
		}else {
			pedido.setTelefono(p.getTelefono());
		}
		if(p.getTipopago()==null || p.getTipopago().equals("")) {
			
		}else {
			pedido.setTipopago(p.getTipopago());
		}
		
		repoPedido.save(pedido);
		
		return pedido;
	}
	
	/**
	 * devuelve la lista de pedidos del usuario
	 * @param usuario
	 * @return
	 */
	
	public List<Pedido> pedidosDelUsuario(User usuario){
		
		List<Pedido> listaDePedidos=null;
		if(usuario.getListapedidos().size()>=1) {
			listaDePedidos=usuario.getListapedidos();
		}
		
		return listaDePedidos;
	}
	/**
	 * comprueba si el usuario tiene un pedido concreto
	 * @param usuario
	 * @param id
	 * @return
	 */
	
	public boolean comprobarPedido(User usuario,Long id) {
		
		List<Pedido> listaDePedidos=pedidosDelUsuario(usuario);
		boolean cajita=false;
		
		for (Pedido pedido : listaDePedidos) {
			if(pedido.getId()==id) {
				cajita=true;
			}
		}
		return cajita;
	}
	
	/**
	 * borra un pedido y posteriro mente llama a borrar ordenador del service ordenadorVendido
	 * @param id
	 */
	
	public void borrarPedido(Long id){
		Pedido pedido=buscarPedido(id);
		repoPedido.deleteById(id);
		serviceOrdenadorVendido.borrarOrdenador(pedido.getOrdenador().getId());
	}
	
}
