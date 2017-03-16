package br.com.infomore.core.impl.negocio.usuario;

import br.com.infomore.core.IStrategy;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Usuario;

public class ValidarLoginUsuario implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
	if (entidade instanceof Usuario) {
	    Usuario usuario = (Usuario) entidade;
	    if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty() || usuario.getSenha() == null
		    || usuario.getSenha().trim().isEmpty())
		return "Por favor, preencha todos os campos!";
	}
	return null;
    }

}
