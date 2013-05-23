package com.bgs_shop.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.bgs_shop.facade.FacadeProdotto;

public class AzioneCatalogo extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		HttpSession sessione = request.getSession();
		FacadeProdotto facade = new FacadeProdotto();
		
		sessione.setAttribute("prodotti", facade.getProdotti());
		
		return "catalogoProdotti";
	}
}
