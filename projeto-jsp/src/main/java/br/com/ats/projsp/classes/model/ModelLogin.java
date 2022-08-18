package br.com.ats.projsp.classes.model;

import java.sql.Timestamp;

/**
 * Classe de autenticação
 */
public class ModelLogin extends GenericDomain {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private String email;
	private String login;
	private String senha;
	private Timestamp dataCadastro;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Timestamp getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
