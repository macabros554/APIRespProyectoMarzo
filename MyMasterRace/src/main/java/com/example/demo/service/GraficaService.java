package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Grafica;
import com.example.demo.repository.GraficaRepo;

@Service("graficaService")
public class GraficaService {
	
	@Autowired
	private GraficaRepo repoGrafica;
	
	/**
	 * busca una grafica en la base de datos por su id y si no lo encuentra devuelve null
	 * @param id
	 * @return grafica
	 */
	
	public Grafica buscarGrafica(Long id) {
		return repoGrafica.findById(id).orElse(null);
	}
	
	/**
	 * Añade una grafica al repositorio de graficas
	 * @param nuevo
	 * @return
	 */
	
	public Grafica anadirGrafica(Grafica nuevo) {
		Grafica una= new Grafica();
		una.setMarca(nuevo.getMarca());
		una.setModelo(nuevo.getModelo());
		una.setNombre(nuevo.getNombre());
		una.setPrecio(nuevo.getPrecio());
		repoGrafica.save(una);
		return una;
	}
	
	/**
	 * saca una lista de todas las graficas de la base de datos
	 * @param id
	 * @return
	 */

	public List<Grafica> findAllGraficas(Long id){
		List<Grafica> listaGraficas=new ArrayList<>();
		for (Grafica grafica : repoGrafica.findAll()) {
			listaGraficas.add(grafica);
		}
		
		return listaGraficas;
	}
}
