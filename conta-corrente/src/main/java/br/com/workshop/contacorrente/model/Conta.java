package br.com.workshop.contacorrente.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.workshop.contacorrente.Enumeration.TipoContaEnum;

@Document(collection = "conta")
public class Conta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 438378068519329905L;
	@Id
	private String id;
	@NotNull
	private String numero;
	@NotNull
	private String agencia;
	@NotNull
	private TipoContaEnum tipo;
	@NotNull
	private String cpf;

	private String nome;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public TipoContaEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoContaEnum tipo) {
		this.tipo = tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
