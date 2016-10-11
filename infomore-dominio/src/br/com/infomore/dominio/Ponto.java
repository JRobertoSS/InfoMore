package br.com.infomore.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
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
@Table(name="pontos")
public class Ponto extends Marcador {
	
	public Ponto() {
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_usuario", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.ALL)
	private Usuario usuario;

	
	@Column(name="certeza")
	private double certeza;
	
    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
	private List<Confirmacao> confirmacoes;

    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public double getCerteza() {
		return certeza;
	}

	public void setCerteza(double certeza) {
		this.certeza = certeza;
	}

	public List<Confirmacao> getConfirmacoes() {
		return confirmacoes;
	}

	public void setConfirmacoes(List<Confirmacao> confirmacoes) {
		this.confirmacoes = confirmacoes;
	}
	
	
}
