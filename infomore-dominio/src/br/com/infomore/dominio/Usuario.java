package br.com.infomore.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
@Table(name="usuarios")
public class Usuario extends Pessoa {

	public Usuario() {
	
	}
	
	@Column(name="email")
	private String email;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="executarWizard")
	private boolean executarWizard;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tipo_usuario", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.ALL)
	private TipoUsuario tipoUsuario;
	
	@OneToMany(mappedBy="usuario", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
	private List<Prioridade> prioridades;
	
	@OneToMany(mappedBy="usuario", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
	private List<Avaliacao> avaliacoes;
	
	@OneToMany(mappedBy="usuario", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
	private List<Confirmacao> confirmacoes;
	
	@OneToMany(mappedBy="usuario", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
	private List<Ponto> pontosIndicados;

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

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<Confirmacao> getConfirmacoes() {
		return confirmacoes;
	}

	public void setConfirmacoes(List<Confirmacao> confirmacoes) {
		this.confirmacoes = confirmacoes;
	}

	public List<Ponto> getPontosIndicados() {
		return pontosIndicados;
	}

	public void setPontosIndicados(List<Ponto> pontosIndicados) {
		this.pontosIndicados = pontosIndicados;
	}
	
	

	
}
