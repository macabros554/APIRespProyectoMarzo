package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.Ordenador;
import com.example.demo.model.User;
import com.example.demo.model.componentes.Disco;
import com.example.demo.model.componentes.Fuente;
import com.example.demo.model.componentes.Grafica;
import com.example.demo.model.componentes.Procesador;
import com.example.demo.model.componentes.Ram;
import com.example.demo.repository.DiscoRepo;
import com.example.demo.repository.FuenteRepo;
import com.example.demo.repository.GraficaRepo;
import com.example.demo.repository.OrdenadoresRepo;
import com.example.demo.repository.ProcesadorRepo;
import com.example.demo.repository.RamRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.DiscoService;
import com.example.demo.service.FuenteService;
import com.example.demo.service.GraficaService;
import com.example.demo.service.ProcesadorService;
import com.example.demo.service.RamService;

@SpringBootApplication
public class EjemploRestServiceJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjemploRestServiceJwtApplication.class, args);
	}
	@Autowired
	private PasswordEncoder codificador;
	
	@Autowired
	private DiscoService serviceDisco;
	
	@Autowired
	private FuenteService serviceFuente;
	
	@Autowired
	private ProcesadorService serviceProcesador;
	
	@Autowired
	private RamService serviceRam;
	
	@Autowired
	private GraficaService serviceGrafica;
	
	@Bean
	CommandLineRunner iniUsuarios(UserRepo repoUsuario) {
		return (arg)-> {
			repoUsuario.save(new User("javi", "javi@gmail.com", "C/guadalpalo", "222444777", codificador.encode("javi"),"visa","756","8888666677774444","Francisco Javier Lira Sánchez"));
		};
	}
	
	@Bean
	CommandLineRunner iniRam(RamRepo repoRam) {
		return (arg)-> {
			repoRam.saveAll(Arrays.asList(new Ram("Kingston HyperX", "DDR4", "DIMM", "8GB", "1x8", 41.90),
					new Ram("Kingston HyperX", "DDR4", "DIMM", "8GB", "2x8", 62.90),
					new Ram("Kingston HyperX", "DDR4", "DIMM", "8GB", "4x8", 100.90),
					new Ram("Kingston FURY", "DDR4", "DIMM", "16GB", "1x16", 60.90),
					new Ram("Kingston FURY", "DDR4", "DIMM", "16GB", "2x16", 99.90),
					new Ram("Kingston FURY", "DDR4", "DIMM", "16GB", "4x16", 140.23)));
		};
	}
	@Bean
	CommandLineRunner iniDisco(DiscoRepo repoDisco) {
		return (arg)-> {
			repoDisco.saveAll(Arrays.asList(new Disco("Seagate BarraCuda", "HDD", "1TB", 45.65),
					new Disco("Seagate BarraCuda", "HDD", "2TB", 60.65),
					new Disco("Kingston A400", "SSD", "480GB", 42.32),
					new Disco("Kingston A400", "SSD", "1TB", 80.90),
					new Disco("Kingston A400", "SSD", "2TB", 140.60)));
		};
	}
	
	@Bean
	CommandLineRunner iniFuente(FuenteRepo repoFuente) {
		return (arg)-> {
			repoFuente.saveAll(Arrays.asList(new Fuente("Nfortec Sagitta", "80 Plus Gold", "650w", 75.90),
					new Fuente("Nfortec Sagitta", "80 Plus Silver", "850w", 89.90),
					new Fuente("Nfortec Sagitta", "80 Plus Gold", "1050w", 105.90),
					new Fuente("Corsair RM750", "80 Plus Gold", "750w", 90.90),
					new Fuente("Corsair RM850", "80 Plus Gold", "850w", 120.90),
					new Fuente("Be Quiet! Dark Power Pro 12", "80 Plus Titanium", "1500W", 500.90)));
		};
	}
	
	@Bean
	CommandLineRunner iniGrafica(GraficaRepo repoGrafica) {
		return (arg)-> {
			repoGrafica.saveAll(Arrays.asList(new Grafica("MSI VENTUS 3X OC", "Nvidia", "RTX 3070 Ti", 980.70),
					new Grafica("Asus Dual OC EVO", "Nvidia", "RTX 3070 Ti", 980.70),
					new Grafica("Sapphire PULSE", "AMD", "RX 6600", 490.90),
					new Grafica("PowerColor FIGHTER", "AMD", "RX 6600", 480.90)));
		};
	}
	
	@Bean
	CommandLineRunner iniProcesador(ProcesadorRepo repoProcesador) {
		return (arg)-> {
			repoProcesador.saveAll(Arrays.asList(new Procesador("AMD Ryzen 5 5600G", "AMD", "Ryzen 5 5600G", "AM4", 237.60),
					new Procesador("AMD Ryzen 7 5700G", "AMD", "Ryzen 7 5700G", "AM4", 328.90),
					new Procesador("Intel Core i7-12700K", "Intel", "Core i7-12700K", "1700", 440.60),
					new Procesador("Intel Core i5-12400F", "Intel", "Core i5-12400F", "1700", 187.60),
					new Procesador("Intel Core i7-11700K", "Intel", "Core i7-11700K", "1200", 343.60),
					new Procesador("Intel Core 5-10400", "Intel", "Core 5-10400", "1200", 160.80)));
		};
	}
	
	/**
	 * Lista de ordenadores
	 * @param repoOedenador
	 * @return
	 */
	
	@Bean
	CommandLineRunner iniOrdenador(OrdenadoresRepo repoOedenador) {
		String enlace1="https://i.ibb.co/GpLydf4/1.png";
		String enlace2="https://static.carrefour.es/hd_510x_/imagenes/products/84254/02437/728/8425402437728/imagenGrande1.jpg";
		String enlace3="https://d10mhq06fikmnr.cloudfront.net/catalog/product/h/u/hunter_rev2_main_rgb-min_4.png";
		String enlace4="https://www.info-computer.com/65105-large_default/-pc-gaming-i5-9400-29-ghz-8gb-ddr4-ssd-480-gb-w10-home-oferta.jpg";
		String enlace5="https://www.info-computer.com/78122-large_default/pc-gaming-amd-ryzen-9-5900x-32-gb-ddr4-2-tb-1-tb-ssd-m2-rtx-3080-ti-12-gb-ddr6x-w10-home-64.jpg";
		
		return (arg)-> {
			serviceDisco.buscarDisco((long) 2);
			repoOedenador.saveAll(Arrays.asList(
					new Ordenador("Huawei MateStation B515", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)3), serviceDisco.buscarDisco((long) 1), serviceGrafica.buscarGrafica((long)1), serviceFuente.buscarFuente((long)1), enlace1, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 240),
					new Ordenador("MSI MAG Codex 5 11TG-814EU", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)1), serviceDisco.buscarDisco((long) 1), serviceGrafica.buscarGrafica((long)1), serviceFuente.buscarFuente((long)2), enlace3, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 562),
					new Ordenador("Lenovo IdeaCentre 5 14IOB6", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace1, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 223),
					new Ordenador("MasterBronze", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace3, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 245),
					new Ordenador("MasterGold", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)4), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace4, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 842),
					new Ordenador("HP Pavilion Desktop TP01-2000ns", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace4, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 643),
					new Ordenador("Dell OptiPlex 3080", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace3, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 546),
					new Ordenador("MasterDiamante", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)3), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace4, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 343.90),
					new Ordenador("MasterBasic", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)1), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace3, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 223),
					new Ordenador("Dell Vostro 3681 ", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace5, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 210.90),
					new Ordenador("Master k32", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace1, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 214.90),
					new Ordenador("Millenium Machine 1 Mini Soraka", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace4, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 500),
					new Ordenador("MasterSilver Pro", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace3, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 100),
					new Ordenador("Master mx2", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)4), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace1, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 220),
					new Ordenador("Master mx1", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 4), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace2, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 320),
					new Ordenador("Master xz3", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)3), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)3), serviceFuente.buscarFuente((long)2), enlace5, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 432.90),
					new Ordenador("HP Pavilion TP01-2001ns", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)4), serviceFuente.buscarFuente((long)2), enlace2, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 110),
					new Ordenador("Legion-Q Tracker3", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace5, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 900),
					new Ordenador("MSI MAG Codex 5 11TG-814EU", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace2, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 300),
					new Ordenador("MSI PRO DP20Z 5M-004EU", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)4), serviceFuente.buscarFuente((long)2), enlace4, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 200.90),
					new Ordenador("MSI MEG Infinite X 10TD-829EU", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace1, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 1200),
					new Ordenador("MSI PRO DP20Z 5M-003EU", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)4), serviceFuente.buscarFuente((long)2), enlace3, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 220),
					new Ordenador("MSI MAG Infinite 11TG-1413EU", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)4), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace2, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 240),
					new Ordenador("MSI MAG Codex X5 11TE-425EU", serviceRam.buscarRam((long)4), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace5, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 380),
					new Ordenador("HP Essential M01-F1106ns", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 4), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace3, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 100.90),
					new Ordenador("HP ProDesk 400 G7 CP", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace2, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 320),
					new Ordenador("HP Z2 G5", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace1, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 300),
					new Ordenador("HP Z1 G6", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace4, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 450),
					new Ordenador("HP 290 G4", serviceRam.buscarRam((long)4), serviceProcesador.buscarProcesador((long)3), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace1, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 100),
					new Ordenador("HP Z2 G5", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)2), serviceDisco.buscarDisco((long) 2), serviceGrafica.buscarGrafica((long)2), serviceFuente.buscarFuente((long)2), enlace5, "Descripción basica", "Pc con tales características preparado para usar en x sectores" , 3, 240.90)));
		};
	}

}
