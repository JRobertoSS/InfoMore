package br.com.infomore.core.impl.negocio.usuario;

import br.com.infomore.core.IStrategy;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.SenhaUsuario;
import br.com.infomore.dominio.Usuario;

public class ValidaAlteracaoSenhaUsuario implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {

	if (entidade instanceof Usuario) {
	    Usuario usuario = (Usuario) entidade;

	    if (usuario.getSenhaUsuario() == null || !usuario.getSenhaUsuario().isAtualizacaoSenha())
		return null;

	    SenhaUsuario senhaUsuario = usuario.getSenhaUsuario();

	    // algum campo vazio?
	    if (senhaUsuario.getSenhaAtual() == null || senhaUsuario.getSenhaAtual().trim().isEmpty()
		    || senhaUsuario.getSenhaNova() == null || senhaUsuario.getSenhaNova().trim().isEmpty()
		    || senhaUsuario.getConfirmaSenhaNova() == null
		    || senhaUsuario.getConfirmaSenhaNova().trim().isEmpty()) {
		return "Por favor, preencha todos os campos!";
	    }

	    // senha atual digita errada?
	    if (!usuario.getSenha().equals(senhaUsuario.getSenhaAtual()))
		return "Senha atual incorreta!";

	    // confirmação de senha não bate com a nova senha?
	    if (!senhaUsuario.getSenhaNova().equals(senhaUsuario.getConfirmaSenhaNova()))
		return "Confirmação de senha diferente da senha nova!";

	    // tudo ok, atualizar nova senha
	    usuario.setSenha(usuario.getSenhaUsuario().getSenhaNova());
	}

	return null;

    }

}
