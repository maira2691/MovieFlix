package model;

/**
*
* @author Marco Rueda
* @since 19-05-2020
* @version 1.0
*/

public class Genero {
	
	private int idGenero = 0;
	private String tipoGenero;
	
	public Genero() {
		super();
	}
	
	public Genero(String tipoGenero) {
		super();
		this.tipoGenero = tipoGenero;
	}

	public Genero(int idGenero, String tipoGenero) {
		super();
		this.idGenero = idGenero;
		this.tipoGenero = tipoGenero;
	}

	public int getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getTipoGenero() {
		return tipoGenero;
	}

	public void setTipoGenero(String tipoGenero) {
		this.tipoGenero = tipoGenero;
	}

	@Override
	public String toString() {
		return "Genero " + tipoGenero;
	}
	
}
