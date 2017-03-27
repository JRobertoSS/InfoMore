package br.com.infomore.core.impl.negocio.usuario;

import br.com.infomore.core.IStrategy;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.SenhaUsuario;
import br.com.infomore.dominio.Usuario;

public class ValidaCamposAlteracaoPerfilUsuario implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		Usuario usuario = (Usuario) entidade;

		SenhaUsuario senhaUsuario = usuario.getSenhaUsuario();

		// algum campo vazio ?
		if ( senhaUsuario.getSenhaNova() == null || senhaUsuario.getSenhaNova().trim().isEmpty() 
				|| senhaUsuario.getConfirmaSenhaNova() == null || senhaUsuario.getConfirmaSenhaNova().trim().isEmpty() 
				||  usuario.getNome() == null || usuario.getNome().trim().isEmpty() 
				|| usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()
				|| usuario.getSenha() == null || usuario.getSenha().trim().isEmpty() 
				|| usuario.getDtNascimento() == null) {
			return "Por favor, preencha todos os campos corretamente!";
		}
		
		return null;
	}
}
