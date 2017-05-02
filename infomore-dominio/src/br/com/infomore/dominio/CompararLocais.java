package br.com.infomore.dominio;

import java.util.List;

public class CompararLocais extends EntidadeDominio{
	private List<String> idsComparacao;

	private List<MeuLocal> meusLocaisComparacao;

	public List<String> getIdsComparacao() {
		return idsComparacao;
	}

	public void setIdsComparacao(List<String> idsComparacao) {
		this.idsComparacao = idsComparacao;
	}

	public List<MeuLocal> getMeusLocaisComparacao() {
		return meusLocaisComparacao;
	}

	public void setMeusLocaisComparacao(List<MeuLocal> meusLocaisComparacao) {
		this.meusLocaisComparacao = meusLocaisComparacao;
	}
	
	
}
