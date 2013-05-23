package com.bgs_shop.persistence;

import java.sql.Connection;

public interface DataSource {
	public Connection getConnection();
}
