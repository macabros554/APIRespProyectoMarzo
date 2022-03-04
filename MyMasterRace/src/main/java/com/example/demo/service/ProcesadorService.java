package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Procesador;
import com.example.demo.repository.ProcesadorRepo;

@Service("procesadorService")
public class ProcesadorService {
	
	@Autowired
	private ProcesadorRepo repoProcesador;
	
	/**
	 * busca un procesador en la base de datos por su id y si no lo encuentra devuelve null
	 * @param id
	 * @return procesador
	 */
	
	public Procesador buscarProcesador(Long id) {
		return repoProcesador.findById(id).orElse(null);
	}
	
	/**
	 * añade el procesador que le pases al repositorio
	 * @param nuevo
	 * @return
	 */
	
	public Procesador anadirProcesador(Procesador nuevo) {
		Procesador una= new Procesador();
		una.setMarca(nuevo.getMarca());
		una.setNombre(nuevo.getNombre());
		una.setModelo(nuevo.getModelo());
		una.setPrecio(nuevo.getPrecio());
		una.setSocket(nuevo.getSocket());
		repoProcesador.save(una);
		return una;
	}
	
	/**
	 * Saca una lista con los procesadores comptatibles segun el procesador que le pase
	 * @param id
	 * @return
	 */
	
	public List<Procesador> listarProcesadoresCompatibles(Long id){
		Procesador referencia=buscarProcesador(id);
		List<Procesador> listaProcesadores=new ArrayList<>();
		for (Procesador procesador : repoProcesador.findAll()) {
			if (referencia.getSocket().equals(procesador.getSocket())) {
				listaProcesadores.add(procesador);
			}
		}
		return listaProcesadores;
	}

}
