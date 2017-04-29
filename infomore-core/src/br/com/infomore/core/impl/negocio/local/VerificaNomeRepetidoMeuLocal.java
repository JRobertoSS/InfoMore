package br.com.infomore.core.impl.negocio.local;

import java.util.List;

import br.com.infomore.core.IStrategy;
import br.com.infomore.core.impl.dao.CategoriaDAO;
import br.com.infomore.core.impl.dao.MeuLocalDAO;
import br.com.infomore.dominio.Categoria;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.MeuLocal;

public class VerificaNomeRepetidoMeuLocal implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		MeuLocal meuLocal = (MeuLocal) entidade;
		
		MeuLocalDAO meuLocalDao = new MeuLocalDAO();
		List<MeuLocal> consulta = meuLocalDao.listarLocaisUsuario(meuLocal);
		
		for(MeuLocal local : consulta){
			if( local.getNome().equals( meuLocal.getNome()) && 
					! local.getId().equals( meuLocal.getId() )){
				return "Já existe um local seu com este nome!";
			}
		}
		
		return null;
	}

}
