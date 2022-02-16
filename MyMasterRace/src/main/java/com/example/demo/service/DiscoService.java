package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Disco;
import com.example.demo.repository.DiscoRepo;

@Service("discoService")
public class DiscoService {
	
	@Autowired
	private DiscoRepo repoDisco;
	
	public Disco buscarDisco(Long id) {
		return repoDisco.findById(id).orElse(null);
	}
	
	public Disco anadirDisco(Disco nuevo) {
		Disco una= new Disco();
		una.setCapacidad(nuevo.getCapacidad());
		una.setNombre(nuevo.getNombre());
		una.setTipo(nuevo.getTipo());
		una.setPrecio(nuevo.getPrecio());
		repoDisco.save(una);
		return una;
	}

}