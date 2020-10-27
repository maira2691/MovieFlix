package controller;

import dao.*;
import model.Cliente;
import utilities.Lector;
import utilities.Display;

/**
 * @author Jorge Herrera
 * @since 20/05/2020
 * @version 2.0
 **/



public class Control {
	
	//Menú general para la gestión de Clientes, el resto de funcionalidades no están aún añadidas
	
	public static void generalManagementMenu() {
		boolean volver = false;
		while(!volver) {
			Display.generalManagementMenu();
			try {
				switch(Lector.leerEntero()) {
					case (1):
						Control.clientManagementMenu(FactoriaDAO.crearDAO("cliente"));
						break;
					case (2):
						System.out.println("No implementado por el momento...");
						break;
					case (3):
						System.out.println("No implementado por el momento...");
						break;
					case (4):
						volver = true;
						break;
					default:
						System.out.println("Numero de opcion no valido");
				}
			} catch (NumberFormatException e) {
				System.out.println("No se ha detectado un entero...");
			}
			System.out.println(" ");
		}
	}
	
	/*Menú para la gestión de clientes
	 * 
	 * guardar dao cliente 
	 * añadir cliente
	 * borrar cliente
	 * modificar datos del cliente
	 */
	
	public static void clientManagementMenu(GenericDAO<?> genericDAO) {
		boolean volver = false;
		ClienteDAO_I dao = null;
		if(genericDAO instanceof ClienteDAO_I) {
			dao = (ClienteDAO_I) genericDAO;
		}
		while(!volver){
			Display.concreteManagementMenu("cliente");
			try {
				switch(Lector.leerEntero()) {
					case(1):
						Cliente c = new Cliente();
						c.crear();
						dao.add(c);
						break;
					case(2):
						System.out.println("Introduzca ID del cliente a borrar");
						dao.delete(dao.findById(Lector.leerEntero()));
						break;
					case(3):
						System.out.println("Introduzca ID del cliente a modificar");
						Cliente cliente = dao.findById(Lector.leerEntero());
						if(cliente != null) {
							System.out.println(cliente.toString());
							cliente.modificar();
						}
						dao.update(cliente);
						break;
					case(4):
						volver = true;
						break;
					default:
						System.out.println("Numero de opcion no valido");
						break;
				}
			} catch (NumberFormatException e) {
				System.out.println("No se ha detectado un entero...");
			}
			System.out.println(" ");
		}
	}
	
	//Método para redirigir a los métodos de gestión de usuarios o elaboración de informes
	
	public static void informationOrManagementMenu() {
		Display.informationOrManagement();
		try {
			switch(Lector.leerEntero()) {
				case(1):
					Control.informationMenu();
					break;
				case(2):
					Control.generalManagementMenu();
					break;
				default:
					System.out.println("Numero de opcion no valido");
					break;
			}
		} catch (NumberFormatException e) {
			System.out.println("No se ha detectado un entero...");
		}
	}
	
	
	//Método para elaborar informes de clientes o películas.
	
	public static void informationMenu() {
		boolean volver = false;
		while(!volver) {
			GenericDAO<?> dao;
			Display.information();
			try {
				switch(Lector.leerEntero()) {
				
				case(1):
					dao = FactoriaDAO.crearDAO("cliente");
					if(dao instanceof ClienteDAO_I)
						Display.list(((ClienteDAO_I)dao).getAll());
					break;
					
				case(2):
					dao = FactoriaDAO.crearDAO("pelicula");
					if(dao instanceof PeliculaDAO_I)
						Display.list(((PeliculaDAO_I) dao).getAll());
					break;
					
				case(3):
					dao = FactoriaDAO.crearDAO("cliente");
					System.out.println("Introduzca ID del usuario del que quiera consultar suscripciones: ");
					Cliente c = null;
					if(dao instanceof ClienteDAO_I) {
						c = ((ClienteDAO_I)dao).findById(Lector.leerEntero());
						if(c != null) {
							System.out.println("El usuario " + c.getNombreCliente() + " con ID " + c.getIdCliente() + 
									" se encuentra suscrito a:  ");
							Display.list(c.getSuscripciones());
						}
					}
					break;
					
				case(4):
					volver = true;
					break;
				default:
					System.out.println("Numero de opcion no valido");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("No se ha detectado un entero...");
			}
		}
		
	}
	
}
