package com.bgs_shop.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bgs_shop.action.Azione;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> comandi; 
	private Map<String, String> esiti; 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prossimaPagina = null;
		String comando = request.getServletPath();
		String nomeAzione = this.comandi.get(comando);
		
		if (nomeAzione==null)
			prossimaPagina = "/error.jsp";
		else {
			Azione azione = null;
			try {
				azione = (Azione)Class.forName(nomeAzione).newInstance();
				String esitoAzione = azione.esegui(request);
				prossimaPagina = this.esiti.get(esitoAzione);
			} 
			catch (InstantiationException e) {
				prossimaPagina = "/error.jsp";
			} 
			catch (IllegalAccessException e) {
				prossimaPagina = "/error.jsp";
			} 
			catch (ClassNotFoundException e) {
				prossimaPagina = "/error.jsp";
			}
		}
		
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
		rd.forward(request, response);		
	} 

	public void init() {
		this.comandi = new HashMap<String, String>();
		this.comandi.put("/login.do","com.bgs_shop.action.AzioneLogin");
		this.comandi.put("/consultaProdotti.do","com.bgs_shop.action.AzioneCatalogo");
		this.comandi.put("/dettagliProdotto.do","com.bgs_shop.action.AzioneDettagli");
		this.comandi.put("/inserisciProdotto.do","com.bgs_shop.action.AzioneInserisciProdotto");
		this.comandi.put("/confermaProdotto.do","com.bgs_shop.action.AzioneConfermaProdotto");
		this.esiti= new HashMap<String, String>();
		this.esiti.put("loginFallito","/loginFallito.jsp");
		this.esiti.put("homeAdmin","/homeAdmin.jsp");
		this.esiti.put("catalogoProdotti","/catalogoProdotti.jsp");
		this.esiti.put("dettaglioProdotto","/dettaglioProdotto.jsp");
		this.esiti.put("inserimentoProdotto","/inserimentoProdotto.jsp");
		this.esiti.put("confermaProdotto","/confermaProdotto.jsp");
		this.esiti.put("inserimentoCompletato","/inserimentoCompletato.jsp");
		this.esiti.put("erroreInserimento","/erroreInserimento.jsp");
	}
}