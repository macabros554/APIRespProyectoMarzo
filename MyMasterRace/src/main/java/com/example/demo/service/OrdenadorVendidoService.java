package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrdenadorVendido;
import com.example.demo.model.Pedido;
import com.example.demo.model.User;
import com.example.demo.repository.OrdenadorVendidoRepo;
import com.example.demo.repository.PedidoRepo;

@Service("ordenadorVendidoService")
public class OrdenadorVendidoService {
	
	@Autowired
	private PedidoRepo repoPedido;
	
	@Autowired
	private OrdenadorVendidoRepo repoOrdenadorVendido;
	
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

		return una;
	}
	
	public List<OrdenadorVendido> findAll(){
		return repoOrdenadorVendido.findAll();
	}
	
	public void borrarOrdenador(Long id) {
		repoOrdenadorVendido.deleteById(id);
	}

}
