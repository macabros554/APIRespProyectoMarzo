package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="ordenador")
public class Ordenador {
	
	private Long id;
	private String nombre;
	private String ram;
	private String procesador;
	private List<String> listadediscosduros=new ArrayList<>();
	private String grafica;
	private String fuente;
	private List<String> imagenes=new ArrayList<>();
	private String descripcion;
	private double precio;
	
	
	
}
