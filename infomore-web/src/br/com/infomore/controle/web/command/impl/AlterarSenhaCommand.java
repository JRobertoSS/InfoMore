
package br.com.infomore.controle.web.command.impl;

import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;


public class AlterarSenhaCommand extends AbstractCommand{

	
	public Resultado execute(EntidadeDominio entidade) {
		
		return fachada.alterar(entidade, "alterarSenha");
	}

}
