package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ordenador;
import com.example.demo.model.OrdenadorVendido;
import com.example.demo.model.Pedido;
import com.example.demo.repository.OrdenadorVendidoRepo;
import com.example.demo.repository.OrdenadoresRepo;
import com.example.demo.repository.PedidoRepo;

@Service("ordenadorVendidoService")
public class OrdenadorVendidoService {
	
	@Autowired
	private PedidoRepo repoPedido;
	
	@Autowired
	private OrdenadorVendidoRepo repoOrdenadorVendido;
	
	@Autowired
	private OrdenadoresRepo repoOrdenadores;
	
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
	
	
	public OrdenadorVendido buscar(Long id) {
		return repoOrdenadorVendido.findById(id).orElse(null);
	}
	
	public OrdenadorVendido anadirOrdenador(OrdenadorVendido nuevo,Long id) {
		OrdenadorVendido una= new OrdenadorVendido();
		una.setNombre(nuevo.getNombre());
		una.setRam(serviceRam.buscarRam(nuevo.getRam().getId()));
		una.setProcesador(serviceProcesador.buscarProcesador(nuevo.getProcesador().getId()));
		una.setDiscoduro(serviceDisco.buscarDisco(nuevo.getDiscoduro().getId()));
		una.setGrafica(serviceGrafica.buscarGrafica(nuevo.getGrafica().getId()));
		una.setFuente(serviceFuente.buscarFuente(nuevo.getFuente().getId()));
		una.setImagenes(nuevo.getImagenes());
		una.setDescripcion(nuevo.getDescripcion());
		una.setPrecio(nuevo.getPrecio());

		repoOrdenadorVendido.save(una);
		
		Pedido pedido=repoPedido.findById(id).orElse(null);
		pedido.setOrdenador(una);
		repoPedido.save(pedido);
		
		Ordenador ordenadorParaBajarCantidad=repoOrdenadores.findById(nuevo.getId()).orElse(null);
		int cantidad = ordenadorParaBajarCantidad.getCantidad()-1;
		ordenadorParaBajarCantidad.setCantidad(cantidad);
		repoOrdenadores.save(ordenadorParaBajarCantidad);
		

		return una;
	}
	
	public OrdenadorVendido modificarOrdenador(OrdenadorVendido nuevo,Long id) {
		Pedido pedido= repoPedido.findById(id).orElse(null);
		OrdenadorVendido una= repoOrdenadorVendido.findById(pedido.getOrdenador().getId()).orElse(nuevo);
		
		if(nuevo.getNombre()!=null) {
			una.setNombre(nuevo.getNombre());
		}
		if(nuevo.getRam()!=null) {
			una.setRam(serviceRam.buscarRam(nuevo.getRam().getId()));
		}
		if(nuevo.getProcesador()!=null) {
			una.setProcesador(serviceProcesador.buscarProcesador(nuevo.getProcesador().getId()));
		}
		if(nuevo.getDiscoduro()!=null) {
			una.setDiscoduro(serviceDisco.buscarDisco(nuevo.getDiscoduro().getId()));
		}
		if(nuevo.getGrafica()!=null) {
			una.setGrafica(serviceGrafica.buscarGrafica(nuevo.getGrafica().getId()));
		}
		if(nuevo.getFuente()!=null) {
			una.setFuente(serviceFuente.buscarFuente(nuevo.getFuente().getId()));
		}
		if(nuevo.getImagenes()!=null) {
			una.setImagenes(nuevo.getImagenes());
		}
		if(nuevo.getDescripcion()!=null) {
			una.setDescripcion(nuevo.getDescripcion());
		}
		if(nuevo.getPrecio()>=1) {
			una.setPrecio(nuevo.getPrecio());
		}

		repoOrdenadorVendido.save(una);
			
		return null;
	}
	
	public List<OrdenadorVendido> findAll(){
		return repoOrdenadorVendido.findAll();
	}
	
	public void borrarOrdenador(Long id) {
		repoOrdenadorVendido.deleteById(id);
	}
	
	public void borrarOrdenadorDePedido(Long id) {
		Pedido pedido= repoPedido.findById(id).orElse(null);
		Long idOedenador=pedido.getOrdenador().getId();
		pedido.setOrdenador(null);
		repoPedido.save(pedido);
		repoOrdenadorVendido.deleteById(idOedenador);
	}

}
