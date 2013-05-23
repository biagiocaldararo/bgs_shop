package com.bgs_shop.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.bgs_shop.facade.FacadeProdotto;
import com.bgs_shop.model.Prodotto;

public class AzioneConfermaProdotto extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String risposta = request.getParameter("risp");
		HttpSession sessione = request.getSession();
		String destinazione = "inserimentoProdotto";
		FacadeProdotto facade = new FacadeProdotto();
		
		if (risposta.equals("si"))
		    if(facade.inserisciProdotto((Prodotto) sessione.getAttribute("prodotto")))
		    	destinazione = "inserimentoCompletato";
		    else 
		    	destinazione = "erroreInserimento";
		
		return destinazione;   
	}
}
