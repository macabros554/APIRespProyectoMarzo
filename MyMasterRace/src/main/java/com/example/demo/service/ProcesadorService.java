package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Procesador;
import com.example.demo.repository.ProcesadorRepo;

@Service("procesadorService")
public class ProcesadorService {
	
	@Autowired
	private ProcesadorRepo repoProcesador;
	
	public Procesador buscarProcesador(Long id) {
		return repoProcesador.findById(id).orElse(null);
	}
	
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

}
