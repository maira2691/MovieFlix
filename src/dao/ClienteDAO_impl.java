package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Genero;
import utilities.DBConnection;

/**
*
* @author Maira Peña
* @author Jorge Herrera
* @author Adnan
* @version 2.0
* @since 19/05/2020
*/


public class ClienteDAO_impl implements ClienteDAO_I{
	
	private Connection con = new DBConnection().getConnection();
	
	//Añadir Cliente
	public void add(Cliente cliente) {
		PreparedStatement stmt;
	    try {
	    	stmt = con.prepareStatement("INSERT INTO cliente (nombre, fechaRegistro) VALUES (?,?)");
			stmt.setString(1, cliente.getNombreCliente());
			stmt.setDate(2, Date.valueOf(cliente.getFechaRegistro()));
			stmt.executeUpdate();
		    System.out.println("Se ha añadido un Cliente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	//Modificar Cliente
	public void update(Cliente cliente) {
		if(cliente != null) {
			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement("UPDATE cliente SET nombre = ?, fechaRegistro = ? WHERE idCliente = ? ;");
				stmt.setString(1, cliente.getNombreCliente());
				stmt.setDate(2, Date.valueOf(cliente.getFechaRegistro()));
				stmt.setInt(3, cliente.getIdCliente());
				stmt.executeUpdate();
				System.out.println("Cliente " + cliente.getIdCliente() + " modificado");
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	//Borrar Cliente
	public void delete(Cliente cliente) {
		if(cliente != null) {
			PreparedStatement stmt1,stmt2;
			ResultSet rs;
			try {
				stmt1 = con.prepareStatement("SELECT idCliente FROM cliente WHERE idCliente = ?;");
				stmt1.setInt(1, cliente.getIdCliente());
				stmt2 = con.prepareStatement("DELETE from cliente where idCliente=?;");
				stmt2.setInt(1, cliente.getIdCliente());
				rs = stmt1.executeQuery();
				while(rs.next()) {
					if(rs != null) {
						stmt2.execute();
						System.out.println("El cliente con ID "+rs.getString("idCliente") + " ha sido borrado");
					}
				}
				rs.close();
				stmt1.close();
				stmt2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//Mostrar Cliente por Id
	public Cliente findById(int idCliente) {
		PreparedStatement stmt;
		ResultSet rs;
		Cliente c = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE idCliente = ?;");
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			if(rs.next())
				c = new Cliente(rs.getInt("idCliente"), rs.getString("nombre"), 
						rs.getDate("fechaRegistro").toLocalDate(), this.clientSuscriptions(rs.getInt("idCliente")));
			else
				System.out.println("Cliente no encontrado");
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	
	//Listar los clientes
	public List<Cliente> getAll() {
		PreparedStatement stmt;
		ResultSet rs;
		List<Cliente> result = new ArrayList<Cliente>();
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente;");
			rs = stmt.executeQuery();
			while(rs.next())
				result.add(new Cliente(rs.getInt("idCliente"), rs.getString("nombre"), 
						rs.getDate("fechaRegistro").toLocalDate(), this.clientSuscriptions(rs.getInt("idCliente"))));
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private List<Genero> clientSuscriptions(int idCliente){
		PreparedStatement stmt;
		ResultSet rs;
		List<Genero> result = new ArrayList<Genero>();
		try {
			stmt = con.prepareStatement("SELECT g.idGenero, g.tipoGenero  FROM suscripcion s "
					+ "JOIN genero g WHERE (s.idGenero =g.idGenero) AND (s.idCliente = ?);");
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			while(rs.next())
				result.add(new Genero(rs.getInt("g.idGenero"), rs.getString("g.tipoGenero")));
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/*public void catalogListForUser(Cliente cliente) {
		int idCliente = cliente.getIdCliente();
		Connection con = new DBConnection().getConnection();
		PreparedStatement stmt;
		ResultSet rs;
		
		try {
			stmt = con.prepareStatement("SELECT c.idCliente, c.nombre, g.tipoGenero FROM suscripcion s INNER JOIN cliente c ON s.idCliente = c.idCliente INNER JOIN genero g ON s.idGenero = g.idGenero WHERE c.idCliente = ? ORDER BY s.idCliente;");
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			
			System.out.println("El cliente "+cliente.getNombreCliente()+"\n");
			while(rs.next()) {
				if(rs != null) {
					System.out.println(rs.getString("g.tipoGenero"));
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
