package com.bgs_shop.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bgs_shop.facade.*;
import com.bgs_shop.model.*;

public class AzioneLogin extends Azione{

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		FacadeAutenticazione facade = new FacadeAutenticazione();
		
		String destinazione = "loginFallito";
		Cliente cliente = facade.login(username, password);
	
		if(cliente!=null){
			HttpSession sessione = request.getSession();
		    sessione.setAttribute("cliente", cliente);
		    destinazione = "homeAdmin";
		}
		
		return destinazione;
	}
}
