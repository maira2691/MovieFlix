package model;

import utilities.Lector;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author Marco Rueda
* @since 19-05-2020
* @version 1.0
*/


public class Cliente {
	
	private int idCliente = 0;
	private String nombreCliente;
	private LocalDate fechaRegistro = LocalDate.now();
	private List<Genero> suscripciones = new ArrayList<Genero>();
	
	public Cliente() {
		super();
	}

	public Cliente(String nombreCliente) {
		super();
		this.nombreCliente = nombreCliente;
	}

	public Cliente(String nombreCliente, LocalDate fechaRegistro) {
		super();
		this.nombreCliente = nombreCliente;
		this.fechaRegistro = fechaRegistro;
	}

	public Cliente(int idCliente, String nombreCliente, LocalDate fechaRegistro, List<Genero> suscripciones) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.fechaRegistro = fechaRegistro;
		this.suscripciones = suscripciones;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public List<Genero> getSuscripciones() {
		return suscripciones;
	}

	public void setSuscripciones(List<Genero> suscripciones) {
		this.suscripciones = suscripciones;
	}

	public void crear() {
		System.out.println("Introduce nombre del cliente: ");
		this.setNombreCliente(Lector.leerString());
	}
	
	public void modificar() {
		crear();
		System.out.println("Introduce fecha de registro (aaaa-mm-dd): ");
		this.setFechaRegistro(LocalDate.parse(Lector.leerString()));
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		StringBuilder generos = new StringBuilder();
		for(Genero g : this.suscripciones)
			generos.append(g.getTipoGenero() + " ");
		
		return "ID: " + idCliente + "\n" + "Nombre: " + nombreCliente + "\n" + "Fecha de registro: "
				+ formatter.format(this.getFechaRegistro()) + "\n" + "Suscrito a: " + generos.toString();
	}

}
