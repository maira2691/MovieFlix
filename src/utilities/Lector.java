package utilities;

import java.util.Scanner;

/**
 * @author Jorge Herrera
 * @since 19/05/2020
 * @version 1.0
 **/

public class Lector {

	private static Scanner scn = new Scanner(System.in);
	
	public static int leerEntero() {
		return Integer.parseInt(Lector.leerString());
	}
	
	public static String leerString() {
		return scn.nextLine();
	}
}
