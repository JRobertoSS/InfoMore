package br.com.infomore.dominio;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="regioes")
public class Regiao extends Marcador {

	public Regiao() {
	}
	
	@Column(name="raio")
	private double raio;
	
	@OneToOne(orphanRemoval = true)
    @JoinColumn(name="id_limite_raio", nullable=false, insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.ALL)
	private LimiteRaio limiteRaio;
	
	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public LimiteRaio getLimiteRaio() {
		return limiteRaio;
	}

	public void setLimiteRaio(LimiteRaio limiteRaio) {
		this.limiteRaio = limiteRaio;
	}

	
}
