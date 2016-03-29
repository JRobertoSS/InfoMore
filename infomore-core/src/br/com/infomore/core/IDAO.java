package br.com.infomore.core;

import java.sql.SQLException;
import java.util.List;

import br.com.infomore.dominio.EntidadeDominio;

public interface IDAO {

	public String salvar(EntidadeDominio entidade) throws SQLException;
	public String alterar(EntidadeDominio entidade)throws SQLException;
	public String excluir(EntidadeDominio entidade)throws SQLException;
	public List<EntidadeDominio> consultar(EntidadeDominio entidade)throws SQLException;
	
}
