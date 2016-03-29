package br.com.infomore.core.impl.negocio;

import java.sql.SQLException;
import java.util.List;

import br.com.infomore.core.IStrategy;
import br.com.infomore.core.impl.dao.UsuarioDAO;
import br.com.infomore.dominio.Usuario;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Pessoa;

public class ValidadorEmailUnico implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		if(entidade instanceof Usuario){
			Usuario cliente = (Usuario) entidade;
			// consultar email e blablabla...
			
		}else{
			return "E-mail não pode ser válidado, pois entidade não é um Usuário!";
		}
		
		
		return null;
	}

}
