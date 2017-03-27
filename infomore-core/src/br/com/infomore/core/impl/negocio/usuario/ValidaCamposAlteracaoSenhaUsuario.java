package br.com.infomore.core.impl.negocio.usuario;

import br.com.infomore.core.IStrategy;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.SenhaUsuario;
import br.com.infomore.dominio.Usuario;

public class ValidaCamposAlteracaoSenhaUsuario implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		Usuario usuario = (Usuario) entidade;

		SenhaUsuario senhaUsuario = usuario.getSenhaUsuario();

		// algum campo vazio ?
		if (((senhaUsuario.getSenhaAtual() == null || senhaUsuario.getSenhaAtual().trim().isEmpty()))
				|| senhaUsuario.getSenhaNova() == null || senhaUsuario.getSenhaNova().trim().isEmpty()
				|| senhaUsuario.getConfirmaSenhaNova() == null
				|| senhaUsuario.getConfirmaSenhaNova().trim().isEmpty()) {
			return "Por favor, preencha todos os campos corretamente!";
		}
		
		return null;
	}
}
