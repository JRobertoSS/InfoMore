package br.com.infomore.core;

import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;


public interface IStrategyProcesso 
{

	public void processar(EntidadeDominio entidade, Resultado resultado);
	
}
