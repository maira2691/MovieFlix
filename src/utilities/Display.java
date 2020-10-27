package utilities;

import java.util.List;


import model.Cliente;
import model.Genero;
import model.Pelicula;

/**
 * @author Jorge Herrera
 * @since 20/05/2020
 * @version 2.0
 **/

//Clase para mostrar información sobre las opciones para realizar en los menús de gestión e informes 

public class Display {
	
	public static void informationOrManagement() {
		System.out.println("Pulse el numero de la funcionalidad a la que quiera acceder: ");
		System.out.println(" 	1.Informes");
		System.out.println(" 	2.Gestion");
	}
	
	public static void generalManagementMenu() {
		System.out.println("Pulse el numero de la gestión deseada: ");
		System.out.println("	1. Gestionar clientes ");
		System.out.println("	2. Gestionar géneros ");
		System.out.println("	3. Gestionar películas ");
		System.out.println("	4. Volver ");
	}
	
	public static void concreteManagementMenu(String tipo) {
		System.out.println("Pulse el numero de la gestión deseada: ");
		System.out.println("	1. Dar de alta "+tipo);
		System.out.println("	2. Dar de baja "+tipo);
		System.out.println("	3. Modificar "+tipo);
		System.out.println("	4. Volver ");
	}
	
	public static void information() {
		System.out.println("Pulse el numero del informe deseado: ");
		System.out.println(" 	1.Todos los clientes");
		System.out.println(" 	2.Todas las peliculas");
		System.out.println(" 	3.Catalogos que puede ver un determinado usuario");
		System.out.println(" 	4.Volver");
	}
	
	public static <T> void list(List<T> list) {
		if(list != null) {
			for(T element: list) {
				System.out.println("------------------------------------------------------------------------------");
				if(element instanceof Pelicula)
					System.out.println(((Pelicula)element).toString());
				else
					if(element instanceof Cliente)
						System.out.println(((Cliente)element).toString());
					else
						if(element instanceof Genero)
							System.out.println(((Genero)element).toString());
				System.out.println("------------------------------------------------------------------------------");
			}
		}
	}
}