package br.com.infomore.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="confirmacoes")
public class Confirmacao extends EntidadeDominio{

	public Confirmacao() {
	}
	
	@Column(name="confirma")
	private boolean confirma;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_ponto", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.ALL)
	private Ponto ponto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_usuario", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.ALL)
	private Usuario usuario;
	
	
	public boolean isConfirma() {
		return confirma;
	}

	public void setConfirma(boolean confirma) {
		this.confirma = confirma;
	}

	public Ponto getPonto() {
		return ponto;
	}

	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
