package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Fuente;
import com.example.demo.repository.FuenteRepo;

@Service("fuenteService")
public class FuenteService {
	
	@Autowired
	private FuenteRepo repoFuente;
	
	/**
	 * busca una fuente en la base de datos por su id y si no lo encuentra devuelve null
	 * @param id
	 * @return
	 */
	
	public Fuente buscarFuente(Long id) {
		return repoFuente.findById(id).orElse(null);
	}
	
	/**
	 * Añade la fuente que le pases al repositorio de fuentes
	 * @param nuevo
	 * @return
	 */
	
	public Fuente anadirFuente(Fuente nuevo) {
		Fuente una= new Fuente();
		una.setCertificacion(nuevo.getCertificacion());
		una.setNombre(nuevo.getNombre());
		una.setPotencia(nuevo.getPotencia());
		una.setPrecio(nuevo.getPrecio());
		repoFuente.save(una);
		return una;
	}
	
	/**
	 * muestra la lista de fuentes de alimentasion
	 * @param id
	 * @return
	 */
	
	public List<Fuente> findAllFuentes(Long id){
		List<Fuente> listaFuentes=new ArrayList<>();
		for (Fuente fuente : repoFuente.findAll()) {
			listaFuentes.add(fuente);
		}
		return listaFuentes;
	}

}
