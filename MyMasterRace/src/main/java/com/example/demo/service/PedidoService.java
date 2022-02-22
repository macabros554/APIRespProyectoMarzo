package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepo;

@Service("pedido")
public class PedidoService {

	@Autowired
	private PedidoRepo repoPedido;
	
	public Pedido crearPedido(Pedido p) {
		if (comprobarPedido(p)==false) {
			return null;
		}
		Pedido pedidoNuevo=new Pedido();
		repoPedido.save(pedidoNuevo);
		
		pedidoNuevo.setCorreoElectronico(p.getCorreoElectronico());
		pedidoNuevo.setDireccion(p.getDireccion());
		pedidoNuevo.setOrdenador(p.getOrdenador());
		pedidoNuevo.setTelefono(p.getTelefono());
		pedidoNuevo.setUsuario(p.getUsuario());
		
		repoPedido.save(pedidoNuevo);
		return pedidoNuevo;
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
