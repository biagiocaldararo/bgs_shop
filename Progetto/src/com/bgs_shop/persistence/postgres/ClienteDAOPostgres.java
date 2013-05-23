package com.bgs_shop.persistence.postgres;

import java.sql.*;

import java.util.*;

import com.bgs_shop.model.*;
import com.bgs_shop.persistence.*;


public class ClienteDAOPostgres implements ClienteDAO {
	private DataSource data;
	private PreparedStatement statement;
	private Connection connection;

	@Override
	public boolean insert(Cliente cliente) {
		this.data = new DataSourcePostgres();
		String insert = "insert into cliente(username, password, ruolo) values (?,?,?)";
		int inserito = 0;
		
		try {
			this.connection = this.data.getConnection();
			this.statement = this.connection.prepareStatement(insert);
			this.statement.setString(1, cliente.getUsername());
			this.statement.setString(2, cliente.getPassword());
			this.statement.setString(3, cliente.getRuolo());
			inserito = this.statement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();	
		} 
		finally {
			try {
				if (this.statement != null) 
					this.statement.close();
				if (this.connection!= null)
					this.connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return inserito!=0;
	}

	@Override
	public boolean delete(Cliente cliente) {
		this.data = new DataSourcePostgres();
		String delete = "delete from cliente where username=?";
		int eliminato = 0;
		
		try {
			this.connection = this.data.getConnection();
			this.statement = this.connection.prepareStatement(delete);
			this.statement.setString(1, cliente.getUsername());
			eliminato = this.statement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();	
		} 
		finally {
			try {
				if (this.statement != null) 
					this.statement.close();
				if (this.connection!= null)
					this.connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return eliminato!=0;
	}

	@Override
	public boolean update(Cliente cliente) {
		this.data = new DataSourcePostgres();
		String update = "update cliente set password=?, ruolo=? where username=?";
		int aggiornato= 0;
		
		try {
			this.connection = this.data.getConnection();
			this.statement = this.connection.prepareStatement(update);
			this.statement.setString(1, cliente.getPassword());
			this.statement.setString(2, cliente.getRuolo());
			this.statement.setString(3, cliente.getUsername());
			aggiornato = this.statement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();	
		} 
		finally {
			try {
				if (this.statement != null) 
					this.statement.close();
				if (this.connection!= null)
					this.connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return aggiornato!=0;
	}

	@Override
	public Cliente findByUsername(String username) {
		this.data = new DataSourcePostgres();
		String query= "select username, password, ruolo from cliente where username=?";
		Cliente cliente = null;	
		
		try {
			this.connection = this.data.getConnection();
			this.statement = this.connection.prepareStatement(query);
			this.statement.setString(1, username);
			ResultSet r = this.statement.executeQuery();
			while (r.next()) 
				cliente = new Cliente(r.getString("username"), r.getString("password"), r.getString("ruolo"));
		} 
		catch (SQLException e) {
			e.printStackTrace();				
		} 
		finally {
			try {
				if (this.statement != null) 
					this.statement.close();
				if (this.connection!= null)
					this.connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cliente;
	}
	
	@Override
	public List<Cliente> findAll() {
		this.data = new DataSourcePostgres();
		String query= "select username, password, ruolo from cliente";
		List<Cliente> clienti = new LinkedList<Cliente>();	
		
		try {
			this.connection = this.data.getConnection();
			this.statement = this.connection.prepareStatement(query);
			ResultSet r = this.statement.executeQuery();
			while (r.next()) {
				Cliente cliente = new Cliente(r.getString("username"), r.getString("password"), r.getString("ruolo"));
				clienti.add(cliente);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();				
		} 
		finally {
			try {
				if (this.statement != null) 
					this.statement.close();
				if (this.connection!= null)
					this.connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return clienti;
	}
}

