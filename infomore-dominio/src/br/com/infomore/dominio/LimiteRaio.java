package br.com.infomore.dominio;

/**
 * Classe para representar os limites de um raio, com um ponto m�ximo no
 * nordeste e um ponto m�nimo no sudoeste, permitindo assim encontrar todos os
 * pontos dentro deste intervalo.
 * 
 * @author Jos� Roberto
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
