package dao;

import model.Genero;

/**
 * @author Jorge Herrera
 * @since 19/05/2020
 * @version 1.0
 **/

public interface GeneroDAO_I extends GenericDAO<Genero> {
	
	/*Interfaz hija con vista a escalabilidad de la aplicación
	 * Posibilidad de incorporar nuevos métodos de filtrado
	 * 
	 * public Lista<Genero> findByTipoGenero(String tipoGenero)
	 * 
	 * ...
	 * 
	 * */
	

}
