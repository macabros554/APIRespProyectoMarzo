package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pedido;
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
	
	
	
	public Pedido crearPedido(Pedido p) {
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
		pedidoNuevo.setTipopado(p.getTipopado());
		pedidoNuevo.setUsuario(p.getUsuario());
		pedidoNuevo.setOrdenador(p.getOrdenador());
		
		serviceOrdenadorVendido.anadirOrdenador(p.getOrdenador());
		
		repoPedido.save(pedidoNuevo);
		
		anadirPedidoAlUsuario(pedidoNuevo.getUsuario().getEmail(),pedidoNuevo.getId());
		
		
		
		
		return pedidoNuevo;
	}
	
	private void anadirPedidoAlUsuario(String email,Long id) {
		User usuario=repoUsuario.findByEmail(email).orElse(null);
		Pedido pedido= repoPedido.findById(id).orElse(null);
		
		usuario.getListapedidos().add(pedido);
		repoUsuario.save(usuario);
		
	}
	
	
	public boolean comprobarPedido(Pedido p1) {
		if(p1.getCorreoElectronico()==null || p1.getDireccion()==null || p1.getTelefono()==null ||
				p1.getCorreoElectronico().equals("") || p1.getDireccion().equals("") || p1.getTelefono().equals("")) {
			return false;
		}else {
			return true;
		}
	}
	
	public Pedido buscarPedido(Long id) {
		return repoPedido.findById(id).orElse(null);
	}
	
	
}
