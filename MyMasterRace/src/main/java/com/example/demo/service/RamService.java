package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Ram;
import com.example.demo.repository.RamRepo;

@Service("ramService")
public class RamService {
	
	@Autowired
	private RamRepo repoRam;
	
	/**
	 * busca una RAM en la base de datos por su id y si no lo encuentra devuelve null
	 * @param id
	 * @return Ram
	 */
	
	public Ram buscarRam(Long id) {
		return repoRam.findById(id).orElse(null);
	}
	
	/**
	 * Añade la ram que le pase al repositorio de RAMs
	 * @param nuevo
	 * @return
	 */
	
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
	
	/**
	 * Saca las RAMs compatible segun la ram que le pase
	 * @param id
	 * @return
	 */
	
	public List<Ram> listarRamsCompatibles(Long id){
		
		Ram referencia=buscarRam(id);
		List<Ram> listaRams=new ArrayList<>();
		for (Ram ram : repoRam.findAll()) {
			if (referencia.getTipo().equals(ram.getTipo())) {
				if (referencia.getFormato().equals(ram.getFormato())) {
					listaRams.add(ram);
				}
			}
		}
		
		return listaRams;
	}

}
