package br.com.infomore.core.impl.dao;

import java.sql.Connection;
import java.util.List;

import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.core.IDAO;
import br.com.infomore.core.jdbc.Conexao;

public abstract class AbstractDAO implements IDAO {
	protected Connection conexao = Conexao.getConnection();

}
