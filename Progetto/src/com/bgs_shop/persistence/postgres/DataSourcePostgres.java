package com.bgs_shop.persistence.postgres;

import java.sql.*;
import com.bgs_shop.persistence.DataSource;

public class DataSourcePostgres implements DataSource {
	private String dbURI = "jdbc:postgresql://localhost/BGS-Shop";
	private String userName = "postgres";
	private String password = "postgres";

	public Connection getConnection(){
		Connection connection = null;
		try {
		    Class.forName("org.postgresql.Driver");
		    connection = DriverManager.getConnection(dbURI,userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
