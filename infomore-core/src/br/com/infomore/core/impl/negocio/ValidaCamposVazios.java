package br.com.infomore.core.impl.negocio;

import java.util.List;

import br.com.infomore.core.IStrategy;
import br.com.infomore.core.impl.dao.UsuarioDAO;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Usuario;
/***
 * 
 * @author Jos�Roberto
 *	Classe para validar se os campos nome, login e senha est�o vazios
 */
public class ValidaCamposVazios implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Usuario usuario = (Usuario) entidade;
		if(usuario.getNome().trim().isEmpty() ||
				usuario.getEmail().trim().isEmpty() ||
				usuario.getSenha().trim().isEmpty())
			return "Todos os campos s�o obrigat�rios! ";
		return null;
	}

}
