package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Genero;
import utilities.DBConnection;

/**
*
* @author Jorge Herrera
* @version 1.0
* @since 21/05/2020
*/


public class GeneroDAO_impl implements GeneroDAO_I {
	
	private Connection con = new DBConnection().getConnection();
	
	//Añadir Cliente
	public void add(Genero genero) {
		if (genero != null) {
			PreparedStatement stmt;
	    	try {
	    		stmt = con.prepareStatement("INSERT INTO genero (tipoGenero) VALUES (?)");
				stmt.setString(1, genero.getTipoGenero());
				stmt.executeUpdate();
		    	System.out.println("Se ha añadido un Genero");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	
	//Modificar Cliente
	public void update(Genero genero) {
		if(genero != null) {
			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement("UPDATE genero SET nombre = ? WHERE idGenero = ? ;");
				stmt.setString(1, genero.getTipoGenero());
				stmt.setInt(2, genero.getIdGenero());
				stmt.executeUpdate();
				System.out.println("Genero " + genero.getIdGenero() + " modificado");
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Genero no encontrado");
		}
	}
	
	
	//Borrar Cliente
	public void delete(Genero genero) {
		if(genero != null) {
			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement("DELETE * from genero WHERE idGenero = ?");
				stmt.setInt(1,genero.getIdGenero());
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			System.out.println("Genero no encontrado");
			
	}
	
	//Mostrar Cliente por Id
	public Genero findById(int idGenero) {
		PreparedStatement stmt;
		ResultSet rs;
		Genero g = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE idCliente = ?;");
			stmt.setInt(1, idGenero);
			rs = stmt.executeQuery();
			if(rs.next())
				g = new Genero(idGenero, rs.getString("tipoGenero"));
			else
				System.out.println("Cliente no encontrado");
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
	}

	
	//Listar los clientes
	public List<Genero> getAll() {
		PreparedStatement stmt;
		ResultSet rs;
		List<Genero> result = new ArrayList<Genero>();
		try {
			stmt = con.prepareStatement("SELECT * FROM genero;");
			rs = stmt.executeQuery();
			while(rs.next())
				result.add(new Genero(rs.getInt("idGenero"), rs.getString("tipoGenero")));
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
