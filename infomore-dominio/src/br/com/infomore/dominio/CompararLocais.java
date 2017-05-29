package br.com.infomore.dominio;

import java.util.List;
import java.util.Map;

public class CompararLocais extends EntidadeDominio{
	private Usuario usuarioLogado; // usuário logado atualmente
	
	private List<Integer> idsComparacao; // lista de ids dos locais que deseja-se comparar

	private List<MeuLocal> meusLocaisComparacao; // lista de resultado das pesquisas com os ids
	
	private Map<Integer, Double> mapaIdPontuacaoLocal; // mapa - chave: id do local | valor: pontuação do local
	
	private Map<Integer, Map<String, Long>> mapaIdCategoriaQuantidade; // mapa - chave: id do local | valor: ( mapa - chave: categoria do ponto | valor: quantidade daqueles pontos da categoria no local)
	
	private Map<Integer, Map<String, Integer>> mapaIdCategoriaMediaAvaliacao; // mapa - chave: id do local | valor: ( mapa - chave: categoria do ponto | valor: média da avaliação dos pontos da categoria no local)

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public List<Integer> getIdsComparacao() {
		return idsComparacao;
	}

	public void setIdsComparacao(List<Integer> idsComparacao) {
		this.idsComparacao = idsComparacao;
	}

	public List<MeuLocal> getMeusLocaisComparacao() {
		return meusLocaisComparacao;
	}

	public void setMeusLocaisComparacao(List<MeuLocal> meusLocaisComparacao) {
		this.meusLocaisComparacao = meusLocaisComparacao;
	}

	public Map<Integer, Double> getMapaIdPontuacaoLocal() {
		return mapaIdPontuacaoLocal;
	}

	public void setMapaIdPontuacaoLocal(Map<Integer, Double> mapaIdPontuacaoLocal) {
		this.mapaIdPontuacaoLocal = mapaIdPontuacaoLocal;
	}

	public Map<Integer, Map<String, Long>> getMapaIdCategoriaQuantidade() {
		return mapaIdCategoriaQuantidade;
	}

	public void setMapaIdCategoriaQuantidade(Map<Integer, Map<String, Long>> mapaIdCategoriaQuantidade) {
		this.mapaIdCategoriaQuantidade = mapaIdCategoriaQuantidade;
	}

	public Map<Integer, Map<String, Integer>> getMapaIdCategoriaMediaAvaliacao() {
		return mapaIdCategoriaMediaAvaliacao;
	}

	public void setMapaIdCategoriaMediaAvaliacao(Map<Integer, Map<String, Integer>> mapaIdCategoriaMediaAvaliacao) {
		this.mapaIdCategoriaMediaAvaliacao = mapaIdCategoriaMediaAvaliacao;
	}
	
	
	
}
