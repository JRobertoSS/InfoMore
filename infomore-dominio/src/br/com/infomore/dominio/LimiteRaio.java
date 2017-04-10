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

/**
 * Classe para representar os limites de um raio, com um ponto máximo no
 * nordeste e um ponto mínimo no sudoeste, permitindo assim encontrar todos os
 * pontos dentro deste intervalo.
 * 
 * @author José Roberto
 *
 */
@Entity
@Table(name="limites_raio")
public class LimiteRaio extends EntidadeDominio {

	@OneToOne(orphanRemoval = true)
    @JoinColumn(name="ponto_ne", nullable=false, insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.ALL)
    private Ponto pontoNE;
	
	@OneToOne(orphanRemoval = true)
    @JoinColumn(name="ponto_sw", nullable=false, insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.ALL)
    private Ponto pontoSW;

    public Ponto getPontoNE() {
	return pontoNE;
    }

    public void setPontoNE(Ponto pontoNE) {
	this.pontoNE = pontoNE;
    }

    public Ponto getPontoSW() {
	return pontoSW;
    }

    public void setPontoSW(Ponto pontoSW) {
	this.pontoSW = pontoSW;
    }

}
