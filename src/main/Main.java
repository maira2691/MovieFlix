package main;

import java.sql.SQLException;
import controller.Control;
//import utilities.ReadCSV;

/** 
 *@author= Jorge Herra Jim�nez
 *@version = 2.0
 *@since= 20/05/2020
 **/


//Llamada al men� para realizar gestion o descargar informes en controller.Control
public class Main {
	public static void main(String[] args) throws SQLException {
		//ReadCSV.leerCSV();
		while(true) {
			Control.informationOrManagementMenu();
		}

	}
	
}
