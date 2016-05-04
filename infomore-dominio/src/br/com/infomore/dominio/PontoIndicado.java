package br.com.infomore.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pontos_indicados")
public class PontoIndicado extends PontoDeUsuario {
	@Column(name="certeza")
	private boolean certeza;
	
	public boolean isCerteza() {
		return certeza;
	}

	public void setCerteza(boolean certeza) {
		this.certeza = certeza;
	}
}
