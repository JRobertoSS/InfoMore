package br.com.infomore.core.impl.negocio.usuario;

import br.com.infomore.core.IStrategy;
import br.com.infomore.core.impl.dao.UsuarioDAO;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Usuario;

public class ValidaEmailUnicoUsuario implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
	if (entidade instanceof Usuario) {
	    Usuario usuario = (Usuario) entidade;

	    if (usuario.getSenhaUsuario() != null && usuario.getSenhaUsuario().isAtualizacaoSenha())
		return null;

	    UsuarioDAO dao = new UsuarioDAO();
	    Usuario consulta = dao.consultarPorEmail(usuario.getEmail());

	    // encontrou um e-mail igual de outro usuário?
	    if (consulta != null && consulta.getId() != usuario.getId())
		return "E-mail " + usuario.getEmail() + " já cadastrado!";

	} else {
	    return "E-mail não pode ser válidado, pois entidade não é um Usuário!";
	}

	return null;
    }

}
