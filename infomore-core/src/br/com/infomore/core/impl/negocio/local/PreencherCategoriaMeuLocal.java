package br.com.infomore.core.impl.negocio.local;

import br.com.infomore.core.IStrategy;
import br.com.infomore.core.impl.dao.CategoriaDAO;
import br.com.infomore.dominio.Categoria;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.MeuLocal;

public class PreencherCategoriaMeuLocal implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		MeuLocal meuLocal = (MeuLocal) entidade;
		CategoriaDAO categoriaDao = new CategoriaDAO();
		Categoria categoria = categoriaDao.consultar(new Categoria(), 8);
		meuLocal.setCategoria(categoria);
		return null;
	}

}
