package com.bgs_shop.persistence;

import java.util.*; 

import com.bgs_shop.model.*;


public interface ProdottoDAO {	
	boolean insert(Prodotto prodotto); 
	boolean delete(Prodotto prodotto); 
	boolean update(Prodotto prodotto);
	Prodotto findByCod(long cod);
 	List<Prodotto> findAll();
}
