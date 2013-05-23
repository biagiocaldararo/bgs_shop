package com.bgs_shop.persistence;

import java.util.List;

import com.bgs_shop.model.*;

public interface ClienteDAO {	
	boolean insert(Cliente cliente); 
	boolean delete(Cliente cliente); 
	boolean update(Cliente utente);
	Cliente findByUsername(String username);
 	List<Cliente> findAll();
}
