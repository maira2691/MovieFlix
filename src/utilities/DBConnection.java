package utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
*
* @author Adnan Hasimbegovic
* @since  19-05-2020
* @version 1.0
*/

//Clase para conectar la aplicación a la base de datos
//Database.properties actualizado para la conexión a la base de datos en remoto
//Futuras implementaciones: creación de un registro para loggear mensajes



public class DBConnection {
	private Connection connection = null;
	public DBConnection() {
		//Se leen y se obtienen las propiedades de la bd, desde el fichero database.properties
        Properties props = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream("database.properties");
            props.load(in);
        } catch (FileNotFoundException ex) {
//            Logger lgr = Logger.getLogger(DBConnection.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException ex) {
//            Logger lgr = Logger.getLogger(DBConnection.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                 if (in != null) {
                     in.close();
                 }
            } catch (IOException ex) {
//                Logger lgr = Logger.getLogger(DBConnection.class.getName());
//                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.passwd");
        String prop = props.getProperty("db.prop");
		try {
			connection = DriverManager.getConnection(url+"?"+prop, user, password);
		} catch (SQLException e) {
//			Logger lgr = Logger.getLogger("main");
//			lgr.log(Level.INFO, "--- Fallo al crear la conexion ---");
//			System.out.println("===========================");
//			lgr.log(Level.SEVERE, "Excepcion SQL: " + e.getMessage(), e);
//			System.out.println("===========================");
//			lgr.log(Level.SEVERE, "Estado SQL: " + e.getSQLState(), e);
//			System.out.println("===========================");
//			lgr.log(Level.SEVERE, "Código del Error: " + e.getErrorCode(), e);
//			System.out.println("===========================");
		}
	}
	public Connection getConnection() {
		return connection;
	}
	public void desconectar() {
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}