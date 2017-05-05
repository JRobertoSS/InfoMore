package br.com.infomore.core.impl.negocio.local.processo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import br.com.infomore.core.IStrategyProcesso;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.CompararLocais;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.MeuLocal;

/**
 * Classe para ordenar a lista dos locais comparados de acordo com a sua
 * pontuação
 * 
 * @author JoséRoberto
 *
 */
public class OrdenarLocaisPontuacao implements IStrategyProcesso {

	@Override
	public void processar(EntidadeDominio entidade, Resultado resultado) {
		CompararLocais compararLocais = (CompararLocais) entidade;

		List<MeuLocal> locaisComparacao = compararLocais.getMeusLocaisComparacao();
		List<MeuLocal> locaisOrdenados = new ArrayList<MeuLocal>();

		while (!locaisComparacao.isEmpty()) {

			Double pontuacaoAlta = (double) Integer.MIN_VALUE;
			int indexLocalPontuacaoAlta = -1;

			for (MeuLocal local : locaisComparacao) {

				Double pontuacaoLocal = compararLocais.getMapaIdPontuacaoLocal().get(local.getId());
				
				if(pontuacaoLocal == null){
					locaisComparacao.remove(locaisComparacao.indexOf(local));
					break;
				}
				
				if (pontuacaoLocal > pontuacaoAlta) {
					pontuacaoAlta = pontuacaoLocal;
					indexLocalPontuacaoAlta = locaisComparacao.indexOf(local);
				}
			}
			
			if (indexLocalPontuacaoAlta >= 0) {
				locaisOrdenados.add(locaisComparacao.get(indexLocalPontuacaoAlta));
				locaisComparacao.remove(indexLocalPontuacaoAlta);
			}

		}

		compararLocais.setMeusLocaisComparacao(locaisOrdenados);
		resultado.getEntidades().add(compararLocais);
	}

}
