package model;


/**
*
* @author Marco Rueda
* @since 19-05-2020
* @version 1.0
*/

public class Suscripcion {
	
	private int idSuscripcion;
	private Genero idGenero;
	private Cliente idCliente;
	
	public Suscripcion() {
		super();
	}

	public Suscripcion(int idSuscripcion, Genero idGenero, Cliente idCliente) {
		super();
		this.idSuscripcion = idSuscripcion;
		this.idGenero = idGenero;
		this.idCliente = idCliente;
	}

	public int getIdSuscripcion() {
		return idSuscripcion;
	}

	public void setIdSuscripcion(int idSuscripcion) {
		this.idSuscripcion = idSuscripcion;
	}

	public Genero getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Genero idGenero) {
		this.idGenero = idGenero;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Suscripcion [idSuscripcion=" + idSuscripcion + ", idGenero=" + idGenero + ", idCliente=" + idCliente
				+ "]";
	}
	
	
	
	

}
