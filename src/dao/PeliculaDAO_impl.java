package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utilities.DBConnection;
import model.Genero;
import model.Pelicula;

/**
*
* @author Maira Peña Quiroz
* @author Marco Rueda
* @version 1.0
* @version 19/05/2020
*/


public class PeliculaDAO_impl implements PeliculaDAO_I{
	
	Connection con = new DBConnection().getConnection();
	
	//Añadir Pelicula
	public void add(Pelicula Pelicula) {
		
	}
	//Modificar Pelicula
	public void update(Pelicula Pelicula) {
		
	}
	
	//Borrar Pelicula
	public void delete(Pelicula Pelicula) {
		
	}
	
	//Mostrar Pelicula por id
	public Pelicula findById(int idPelicula) {
		PreparedStatement stmt;
		ResultSet rs;
		Pelicula p = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM pelicula WHERE idPelicula = ?;");
			stmt.setInt(1, idPelicula);
			rs = stmt.executeQuery();
			if(rs.next())
				p = new Pelicula(idPelicula, rs.getString("titulo"), rs.getInt("anyoEstreno"),
						new Genero(rs.getInt("idGenero"), rs.getString("tipoGenero")));
			else
				System.out.println("Cliente no encontrado");
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	//Listar las Peliculas
	public List<Pelicula> getAll() {
		PreparedStatement stmt;
		ResultSet rs;
		List<Pelicula> result = new ArrayList<Pelicula>();
		try {
			stmt = con.prepareStatement("SELECT * FROM pelicula p JOIN genero g WHERE p.idGenero = g.idGenero;");
			rs = stmt.executeQuery();
			while(rs.next())
				result.add(new Pelicula(rs.getInt("idPelicula"), rs.getString("titulo"), rs.getInt("anyoEstreno"),
						new Genero(rs.getInt("idGenero"), rs.getString("tipoGenero"))));
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

}
