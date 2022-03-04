package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ordenador;
import com.example.demo.repository.OrdenadoresRepo;

@Service("ordenadorService")
public class OrdenadorService {
	
	@Autowired
	private OrdenadoresRepo repoOrdenador;
	
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
	
	/**
	 * busca un ordenador en la base de datos por su id y si no lo encuentra devuelve null
	 * @param id
	 * @return ordenador
	 */
	
	public Ordenador buscar(Long id) {
		return repoOrdenador.findById(id).orElse(null);
	}
	
	public Ordenador anadirOrdenador(Ordenador nuevo) {
		Ordenador una= new Ordenador();
		una.setNombre(nuevo.getNombre());
		una.setRam(serviceRam.buscarRam(nuevo.getRam().getId()));
		una.setProcesador(serviceProcesador.buscarProcesador(nuevo.getProcesador().getId()));
		una.setDiscoduro(serviceDisco.buscarDisco(nuevo.getDiscoduro().getId()));
		una.setGrafica(serviceGrafica.buscarGrafica(nuevo.getGrafica().getId()));
		una.setFuente(serviceFuente.buscarFuente(nuevo.getFuente().getId()));
		una.setImagenes(nuevo.getImagenes());
		una.setDescripcion(nuevo.getDescripcion());
		una.setPrecio(nuevo.getPrecio());

		repoOrdenador.save(una);
		return una;
	}
	
	/**
	 * saca una lista de todos los ordenadores a la venta del repositorio
	 * @return
	 */
	
	public List<Ordenador> findAll(){
		return repoOrdenador.findAll();
	}

}
