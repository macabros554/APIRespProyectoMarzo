package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Ram;
import com.example.demo.repository.RamRepo;

@Service("ramService")
public class RamService {
	
	@Autowired
	private RamRepo repoRam;
	
	public Ram buscarRam(Long id) {
		return repoRam.findById(id).orElse(null);
	}
	
	public Ram anadirRam(Ram nuevo) {
		Ram una= new Ram();
		una.setNombre(nuevo.getNombre());
		una.setCapacidad(nuevo.getCapacidad());
		una.setFormato(nuevo.getFormato());
		una.setKit(nuevo.getKit());
		una.setTipo(nuevo.getTipo());
		una.setPrecio(nuevo.getPrecio());
		repoRam.save(una);
		return una;
	}

}
