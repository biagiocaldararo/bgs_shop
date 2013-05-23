package com.bgs_shop.model;

public class Prodotto {
	private long cod;
	private String nome;
	private String descrizione;
	private double prezzo;
	
	public Prodotto(){
	}
	
	public Prodotto(long cod, String nome, String descrizione, double prezzo){
		this.setCod(cod);
		this.setNome(nome);
		this.setDescrizione(descrizione);
		this.setPrezzo(prezzo);
	}

	public long getCod() {
		return cod;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
}
