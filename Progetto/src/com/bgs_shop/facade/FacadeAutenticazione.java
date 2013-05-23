package com.bgs_shop.facade;

import com.bgs_shop.model.*;
import com.bgs_shop.persistence.postgres.*;


public class FacadeAutenticazione {
	public Cliente login (String username, String password){
		ClienteDAOPostgres dao = new ClienteDAOPostgres();
		Cliente cliente = dao.findByUsername(username);
		boolean autenticato = true;
		
		if(cliente!=null) 
			autenticato &= cliente.getPassword().equals(password);
		
		if(!autenticato)
			cliente = null;
		
		return cliente;
	}
}
