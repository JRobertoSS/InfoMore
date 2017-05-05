package br.com.infomore.core.impl.negocio.local.processo;

import java.util.ArrayList;
import java.util.List;

import br.com.infomore.core.IStrategyProcesso;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.core.impl.dao.MeuLocalDAO;
import br.com.infomore.dominio.CompararLocais;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.MeuLocal;

/**
 * Classe que irá pesquisar e preencher na lista todos os locais que serão
 * comparados
 * @author JoséRoberto
 *
 */
public class PesquisarLocaisComparacao implements IStrategyProcesso {

	@Override
	public void processar(EntidadeDominio entidade, Resultado resultado) {
		CompararLocais compararLocais = (CompararLocais) entidade;
		
		MeuLocalDAO meuLocalDao = new MeuLocalDAO();
		List<MeuLocal> locaisComparacao = new ArrayList<MeuLocal>();
		
		for(Integer id: compararLocais.getIdsComparacao()){
			MeuLocal localPesquisa = meuLocalDao.consultar(new MeuLocal(), id);
			locaisComparacao.add(localPesquisa);
		}
		
		compararLocais.setMeusLocaisComparacao(locaisComparacao);

	}

}
