package br.com.infomore.dominio;

import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Usuario extends Pessoa {

	private String email;

	private String senha;

	private boolean executarWizard;

	@ManyToOne
	private TipoUsuario tipoUsuario;
	
	@OneToMany
	private List<Prioridade> prioridades;

	@OneToMany
	private List<Confirmacao> confirmacoes;
	
	@OneToMany
	private List<Avaliacao> avaliacoes;
	
	@OneToMany
	private List<PontoIndicado> pontosIndicados;
	
	@OneToMany
	private List<PontoFavorito> pontosFavoritos;

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

	public boolean isExecutarWizard() {
		return executarWizard;
	}

	public void setExecutarWizard(boolean executarWizard) {
		this.executarWizard = executarWizard;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Prioridade> getPrioridades() {
		return prioridades;
	}

	public void setPrioridades(List<Prioridade> prioridades) {
		this.prioridades = prioridades;
	}

	public List<Confirmacao> getConfirmacoes() {
		return confirmacoes;
	}

	public void setConfirmacoes(List<Confirmacao> confirmacoes) {
		this.confirmacoes = confirmacoes;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<Ponto> getPontosIndicados() {
		return pontosIndicados;
	}

	public void setPontosIndicados(List<Ponto> pontosIndicados) {
		this.pontosIndicados = pontosIndicados;
	}

	public List<Ponto> getPontosFavoritos() {
		return pontosFavoritos;
	}

	public void setPontosFavoritos(List<Ponto> pontosFavoritos) {
		this.pontosFavoritos = pontosFavoritos;
	}
	
	
}
