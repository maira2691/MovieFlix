package dao;

import model.Pelicula;

/**
 * @author Jorge Herrera
 * @since 19/05/2020
 * @version 1.0
 **/

public interface PeliculaDAO_I extends GenericDAO<Pelicula> {

	/*Interfaz hija con vista a escalabilidad de la aplicación
	 * Posibilidad de incorporar nuevos métodos de filtrado
	 * 
	 * public Lista<Pelicula> findByTitulo(String titulo)
	 * 
	 * ...
	 * 
	 * */
}
