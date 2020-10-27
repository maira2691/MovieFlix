package utilities;


/**
 * 
 * @author Adnan Hasimbegovic
 * @since 19-05-2020
 * @version 1.0
 */


//Clase para leer fichero CSV y copiar información a la base de datos

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class ReadCSV {
	public static final String SEPARADOR = ",";

	public static void leerCSV() throws SQLException {

		// Variables para las conexiones
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		BufferedReader bufferLectura = null;

		try {
			// Abrir el .csv en buffer de lectura
			bufferLectura = new BufferedReader(new FileReader("data/datos1.csv"));
			// Leer una linea del archivo
			String linea = bufferLectura.readLine();
			
			//Iniciamos conexion con Base Datos
			con = new DBConnection().getConnection();

			while (linea != null) {
				// Sepapar la linea leída con el separador definido previamente
				String[] campos = linea.split(SEPARADOR);

				

				stmt = con.prepareStatement("INSERT INTO pelicula VALUES (?,?,?,?)");

				stmt.setInt(1, 0);
				stmt.setString(2, campos[0]);
				stmt.setString(3, campos[1]);
				stmt.setString(4, campos[2]);

				stmt.executeUpdate();
				System.out.println(Arrays.toString(campos));

				// Volver a leer otra línea del fichero
				linea = bufferLectura.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Cierro el buffer de lectura
			if (bufferLectura != null) {
				try {
					bufferLectura.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
