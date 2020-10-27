package dao;

import model.Pelicula;

/**
 * @author Jorge Herrera
 * @since 19/05/2020
 * @version 1.0
 **/

public interface PeliculaDAO_I extends GenericDAO<Pelicula> {

	/*Interfaz hija con vista a escalabilidad de la aplicaci�n
	 * Posibilidad de incorporar nuevos m�todos de filtrado
	 * 
	 * public Lista<Pelicula> findByTitulo(String titulo)
	 * 
	 * ...
	 * 
	 * */
}
