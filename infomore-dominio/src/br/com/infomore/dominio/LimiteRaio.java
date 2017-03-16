package br.com.infomore.dominio;

/**
 * Classe para representar os limites de um raio, com um ponto máximo no
 * nordeste e um ponto mínimo no sudoeste, permitindo assim encontrar todos os
 * pontos dentro deste intervalo.
 * 
 * @author José Roberto
 *
 */
public class LimiteRaio extends EntidadeDominio {

    private Ponto pontoNE;
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
