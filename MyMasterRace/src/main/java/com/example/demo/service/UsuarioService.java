package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pedido;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service("usuario")
public class UsuarioService {

	@Autowired
	private UserRepo repoUsuario;
	
	@Autowired
	private PedidoService servicePedido;
	
	/**
	 * busca un usuario en la base de datos por su id y si no lo encuentra devuelve null
	 * @param id
	 * @return usuario
	 */
	
	public User buscarUsuario(String email) {
		return repoUsuario.findByEmail(email).orElse(null);
	}
	
	public void borrarPedido(Long id, String email) {
		User usuario = repoUsuario.findByEmail(email).orElse(null);
		List<Pedido> listaPedidos=usuario.getListapedidos();
		listaPedidos.remove(servicePedido.buscarPedido(id));
		usuario.setListapedidos(listaPedidos);
		repoUsuario.save(usuario);
		servicePedido.borrarPedido(id);
	}
	
	public void borrarUsuario(String email) {
		User usuario = repoUsuario.findByEmail(email).orElse(null);
		List<Pedido> listaPedidos=usuario.getListapedidos();
		for (Pedido pedido : listaPedidos) {
			servicePedido.borrarPedido(pedido.getId());
		}
		repoUsuario.deleteById(email);
	}
	
	public User modificarUsuario(User usuario) {
		User elUsuario=repoUsuario.findByEmail(usuario.getEmail()).orElse(null);
		
		if (usuario.getCalle()!=null) {
			elUsuario.setCalle(usuario.getCalle());
		}
		if(usuario.getCodigotarjeta()!=null) {
			elUsuario.setCodigotarjeta(usuario.getCodigotarjeta());
		}
		if(usuario.getDueniotarjeta()!=null) {
			elUsuario.setDueniotarjeta(usuario.getDueniotarjeta());
		}
		if(usuario.getName()!=null) {
			elUsuario.setName(usuario.getName());
		}
		if(usuario.getPassword()!=null) {
			elUsuario.setPassword(usuario.getPassword());
		}
		if(usuario.getTarjeta()!=null) {
			elUsuario.setTarjeta(usuario.getTarjeta());
		}
		if(usuario.getTelefono()!=null) {
			elUsuario.setTelefono(usuario.getTelefono());
		}
		if(usuario.getTipopado()!=null) {
			elUsuario.setTipopado(usuario.getTipopado());
		}
		repoUsuario.save(elUsuario);
		return elUsuario;
	}
	
}
