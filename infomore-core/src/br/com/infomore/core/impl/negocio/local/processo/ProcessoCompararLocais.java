package br.com.infomore.core.impl.negocio.local.processo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.javafx.collections.MapAdapterChange;

import br.com.infomore.core.IStrategyProcesso;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.core.impl.dao.LimiteRaioDAO;
import br.com.infomore.dominio.Categoria;
import br.com.infomore.dominio.CompararLocais;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.LimiteRaio;
import br.com.infomore.dominio.MeuLocal;
import br.com.infomore.dominio.Ponto;
import br.com.infomore.dominio.Prioridade;
import br.com.infomore.dominio.Usuario;

/**
 * Classe que irá comparar os pontos de cada local escolhido, baseado em suas categorias
 * e nas prioridades definidas pelo usuário, fazendo uma somatória e definindo uma pontuação
 * @author JoséRoberto
 *
 */
public class ProcessoCompararLocais implements IStrategyProcesso {

	@Override
	public void processar(EntidadeDominio entidade, Resultado resultado) {
		CompararLocais compararLocais = (CompararLocais) entidade;
		compararLocais.setMapaIdPontuacaoLocal( new HashMap<Integer, Double>());
		compararLocais.setMapaIdCategoriaQuantidade( new HashMap<Integer, Map<String,Long>>());
		
		Usuario usuario = compararLocais.getUsuarioLogado();
		
		Map<String, Double> mapaPrioridadePeso = new HashMap<String, Double>(); // mapa para guardar as prioridades do usuário pelo nome da categoria
		
		for(Prioridade prioridade : usuario.getPrioridades()){
			mapaPrioridadePeso.put(prioridade.getCategoria().getNome(), prioridade.getPeso());
		}
		
		
		LimiteRaioDAO limiteRaioDao = new LimiteRaioDAO(); // para pesquisa dos pontos no limite do raio
		
		// varrer todos os locais desejados na comparação
		for(MeuLocal local : compararLocais.getMeusLocaisComparacao()){
			
			Map<String, Long> mapaCategoriaQuantidade = getMapaCategoriaQuantidade(); // para identificar quantos locais de cada categoria há no local
			
			Double pontuacaoDoLocal = 0.0;
			
			// consulta dos pontos dentro do limite de raio deste local
			List<Ponto> pontosNoLimiteRaio = limiteRaioDao.listar( local.getLimiteRaio());
			
			// varrer cada ponto deste limite raio
			for( Ponto ponto: pontosNoLimiteRaio){
				
				String categoriaDoPonto = ponto.getCategoria().getNome();
				
				// se for uma ocorrência, subtrair pontos no total
				// se não for uma ocorrência, adicionar pontos no total
				// em ambos os casos, os pontos são da classificação do usuário
				if( ponto.isOcorrencia() ){
					pontuacaoDoLocal -= mapaPrioridadePeso.get(categoriaDoPonto);
				} else {
					pontuacaoDoLocal += mapaPrioridadePeso.get(categoriaDoPonto);
				}
				
				Long quantidadeDaCategoria = mapaCategoriaQuantidade.get(categoriaDoPonto); // recupera a quantidade daquela categoria
				quantidadeDaCategoria++; // incrementa a quantidade
				mapaCategoriaQuantidade.put(categoriaDoPonto, quantidadeDaCategoria); // atualiza o mapa com a quantidade incrementada
			}
			
			/*
			 * Preencher o CompararLocais com as informações analisadas deste local
			 */
			// adiciona no mapa a pontuação do local, indexada pelo ID
			compararLocais.getMapaIdPontuacaoLocal().put(local.getId(), pontuacaoDoLocal);
			// adiciona no mapa de quantidade de locais de cada categoria, indexado por id do local e nome da categoria
			compararLocais.getMapaIdCategoriaQuantidade().put(local.getId(), mapaCategoriaQuantidade);
		}

	}

	private Map<String, Long> getMapaCategoriaQuantidade() {
		Map<String, Long> mapaCategoriaQuantidade = new HashMap<String, Long>();
		mapaCategoriaQuantidade.put(Categoria.COMODIDADES, 0L);
		mapaCategoriaQuantidade.put(Categoria.EDUCACAO, 0L);
		mapaCategoriaQuantidade.put(Categoria.LAZER_CULTURA, 0L);
		mapaCategoriaQuantidade.put(Categoria.OCORRENCIAS, 0L);
		mapaCategoriaQuantidade.put(Categoria.SAUDE, 0L);
		mapaCategoriaQuantidade.put(Categoria.SEGURANCA, 0L);
		mapaCategoriaQuantidade.put(Categoria.TRANSPORTES, 0L);
		return mapaCategoriaQuantidade;
	}
	
	

}
