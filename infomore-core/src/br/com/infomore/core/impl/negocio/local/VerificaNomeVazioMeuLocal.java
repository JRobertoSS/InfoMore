package br.com.infomore.core.impl.negocio.local;

import br.com.infomore.core.IStrategy;
import br.com.infomore.core.impl.dao.CategoriaDAO;
import br.com.infomore.dominio.Categoria;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.MeuLocal;

public class VerificaNomeVazioMeuLocal implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		MeuLocal meuLocal = (MeuLocal) entidade;
		
		if( meuLocal.getNome() == null || 
				meuLocal.getNome().trim().isEmpty())
			return "Por favor, digite um nome para este local!";
		
		return null;
	}

}
