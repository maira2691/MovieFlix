package dao;

import java.util.List;

/**
 * @author Jorge Herrera
 * @since 19/05/2020
 * @version 1.0
 **/

//Interfaz genérica para elaborar DAOs de los objetos principales del programa

public interface GenericDAO<T> {

	//Añadir elemento instancia de T
	public void add(T element);
	
	//Actualizar elemento instancia de T
	public void update(T element);
	
	//Eliminar elemento instancia de T
	public void delete(T element);
	
	//Encontrar elemento instancia de T por su ID
	public T findById(int element);
	
	//Recuperar una lista de elmentos, instancias de T
	public List<T> getAll();
	
}
