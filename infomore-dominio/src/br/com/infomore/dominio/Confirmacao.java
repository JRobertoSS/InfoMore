package br.com.infomore.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="confirmacoes")
public class Confirmacao extends EntidadeDominio{

	@Column(name="confirma")
	private boolean confirma;
	
	@ManyToOne
	private Usuario usuario;

	public boolean isConfirma() {
		return confirma;
	}

	public void setConfirma(boolean confirma) {
		this.confirma = confirma;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
