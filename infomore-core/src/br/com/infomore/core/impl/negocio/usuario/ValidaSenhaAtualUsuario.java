package br.com.infomore.core.impl.negocio.usuario;

import br.com.infomore.core.IStrategy;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.SenhaUsuario;
import br.com.infomore.dominio.Usuario;

public class ValidaSenhaAtualUsuario implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		Usuario usuario = (Usuario) entidade;

		SenhaUsuario senhaUsuario = usuario.getSenhaUsuario();
		
		// senha atual digitada errada e não é um cadastro?
		if (!usuario.getSenha().equals(senhaUsuario.getSenhaAtual()))
			return "Senha atual incorreta!";

		return null;

	}

}
