package br.com.infomore.core;

import br.com.infomore.dominio.EntidadeDominio;


public interface IStrategy 
{

	public String processar(EntidadeDominio entidade);
	
}
