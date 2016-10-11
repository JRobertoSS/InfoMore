package br.com.infomore.core.impl.negocio;

import br.com.infomore.core.IStrategy;
import br.com.infomore.core.impl.dao.UsuarioDAO;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Usuario;

public class ValidadorEmailUnico implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
	if (entidade instanceof Usuario) {
	    Usuario usuario = (Usuario) entidade;
	    UsuarioDAO dao = new UsuarioDAO();
	    Usuario consulta = dao.consultarPorEmail(usuario.getEmail());
	    if (consulta != null)
		return "E-mail " + usuario.getEmail() + " j� cadastrado!";

	} else {
	    return "E-mail n�o pode ser v�lidado, pois entidade n�o � um Usu�rio!";
	}

	return null;
    }

}
