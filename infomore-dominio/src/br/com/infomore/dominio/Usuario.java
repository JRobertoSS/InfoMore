package br.com.infomore.dominio;

import java.util.List;


public class Usuario extends Pessoa {

	private String email;

	private String senha;

	private Boolean executarWizard;
	
	public Usuario (){
		setExecutarWizard(true);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getExecutarWizard() {
		return executarWizard;
	}

	public void setExecutarWizard(Boolean executarWizard) {
		this.executarWizard = executarWizard;
	}

}
