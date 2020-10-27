package dao;

/**
 * @author Jorge Herrera
 * @since 19/05/2020
 * @version 1.0
 **/


//Crear un DAO del objeto instanciado en el método generalManagement en la clase Control (solo permite crear DAOCLiente por ahora)

public class FactoriaDAO {
	
	public static GenericDAO<?> crearDAO(String tipo) {
		switch(tipo.toUpperCase()) {
			case ("CLIENTE"):
				return  new ClienteDAO_impl();
			
			case ("PELICULA"):
				return new PeliculaDAO_impl();
			
			case("GENERO"):
				return new GeneroDAO_impl();
			default:
				return null;
		}
			
	}

}
