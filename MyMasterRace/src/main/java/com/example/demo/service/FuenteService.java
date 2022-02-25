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
	
	public Fuente buscarFuente(Long id) {
		return repoFuente.findById(id).orElse(null);
	}
	
	public Fuente anadirFuente(Fuente nuevo) {
		Fuente una= new Fuente();
		una.setCertificacion(nuevo.getCertificacion());
		una.setNombre(nuevo.getNombre());
		una.setPotencia(nuevo.getPotencia());
		una.setPrecio(nuevo.getPrecio());
		repoFuente.save(una);
		return una;
	}
	
	public List<Fuente> findAllFuentes(Long id){
		List<Fuente> listaFuentes=new ArrayList<>();
		for (Fuente fuente : repoFuente.findAll()) {
			listaFuentes.add(fuente);
		}
		return listaFuentes;
	}

}
