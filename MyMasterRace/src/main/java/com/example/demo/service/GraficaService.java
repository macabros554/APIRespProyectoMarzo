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
	
	public Grafica buscarGrafica(Long id) {
		return repoGrafica.findById(id).orElse(null);
	}
	
	public Grafica anadirGrafica(Grafica nuevo) {
		Grafica una= new Grafica();
		una.setMarca(nuevo.getMarca());
		una.setModelo(nuevo.getModelo());
		una.setNombre(nuevo.getNombre());
		una.setPrecio(nuevo.getPrecio());
		repoGrafica.save(una);
		return una;
	}

	public List<Grafica> findAllGraficas(Long id){
		Grafica referencia=buscarGrafica(id);
		List<Grafica> listaGraficas=new ArrayList<>();
		for (Grafica grafia : repoGrafica.findAll()) {
			if (referencia.getId().equals(grafia.getId())) {
				
			}else {
				listaGraficas.add(grafia);
			}
		}
		return listaGraficas;
	}
}
