
package br.com.infomore.controle.web.command;

import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;


public interface ICommand {

	public Resultado execute(EntidadeDominio entidade);
	
}
