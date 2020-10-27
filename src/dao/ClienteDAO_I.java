package dao;

import model.Cliente;

/**
 * @author Jorge Herrera
 * @version 19/05/2020
 **/

public interface ClienteDAO_I extends GenericDAO<Cliente> {
	
	/*Interfaz hija con vista a escalabilidad de la aplicaci�n
	 * Posibilidad de incorporar nuevos m�todos de filtrado
	 * 
	 * public Lista<Cliente> findByDate(Date date)
	 * 
	 * public Lista<Cliente> findByNombre(String nombre)
	 * 
	 * ...
	 * 
	 * */
	
}
