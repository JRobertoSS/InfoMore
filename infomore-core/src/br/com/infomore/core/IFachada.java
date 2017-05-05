package br.com.infomore.core;

import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;

public interface IFachada {

	public Resultado salvar(EntidadeDominio entidade);
	public Resultado alterar(EntidadeDominio entidade, String tipoAlteracao);
	public Resultado excluir(EntidadeDominio entidade);
	public Resultado consultar(EntidadeDominio entidade);
	public Resultado listar(EntidadeDominio entidade);
	public Resultado processar(EntidadeDominio entidade);
	
}
