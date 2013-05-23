package com.bgs_shop.facade;

import java.util.*;

import com.bgs_shop.model.*;
import com.bgs_shop.persistence.postgres.*;


public class FacadeProdotto {
	public List<Prodotto> getProdotti(){
		ProdottoDAOPostgres p = new ProdottoDAOPostgres();
		return p.findAll();
	}
	
	public boolean inserisciProdotto(Prodotto prodotto){
		ProdottoDAOPostgres p = new ProdottoDAOPostgres();
		return p.insert(prodotto);
	}	
}
