package model;

/**
*
* @author Marco Rueda
* @since 19-05-2020
* @version 1.0
*/

public class Pelicula {
	
	private int idPelicula;
	private String titulo;
	private int anyoEstreno;
	private Genero genero;
	
	public Pelicula() {
		super();
	}

	public Pelicula(int idPelicula, String titulo, int anyoEstreno, Genero idGenero) {
		super();
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.anyoEstreno = anyoEstreno;
		this.genero = idGenero;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnyoEstreno() {
		return anyoEstreno;
	}

	public void setAnyoEstreno(int anyoEstreno) {
		this.anyoEstreno = anyoEstreno;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "ID: " + idPelicula + "\n" +
				"Titulo: " + titulo + "\n" +
				"Año de estreno: " + anyoEstreno + "\n"
				+ "Genero: " + genero.getTipoGenero() + "\n";
	}
}
