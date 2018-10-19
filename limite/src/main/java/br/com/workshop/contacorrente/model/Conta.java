package br.com.workshop.contacorrente.model;

import java.io.Serializable;


public class Conta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 438378068519329905L;
	private String numero;
	private String agencia;
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
}
