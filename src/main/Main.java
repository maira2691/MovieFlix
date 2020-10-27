package main;

import java.sql.SQLException;
import controller.Control;
//import utilities.ReadCSV;

/** 
 *@author= Jorge Herra Jiménez
 *@version = 2.0
 *@since= 20/05/2020
 **/


//Llamada al menú para realizar gestion o descargar informes en controller.Control
public class Main {
	public static void main(String[] args) throws SQLException {
		//ReadCSV.leerCSV();
		while(true) {
			Control.informationOrManagementMenu();
		}

	}
	
}
