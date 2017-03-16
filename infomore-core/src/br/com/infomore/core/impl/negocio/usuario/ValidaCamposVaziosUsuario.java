package br.com.infomore.core.impl.negocio.usuario;

import br.com.infomore.core.IStrategy;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Usuario;

/***
 * 
 * @author JoséRoberto Classe para validar se os campos nome, login e senha
 *         estão vazios
 */
public class ValidaCamposVaziosUsuario implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
	Usuario usuario = (Usuario) entidade;

	if (usuario.getSenhaUsuario() != null && usuario.getSenhaUsuario().isAtualizacaoSenha())
	    return null;

	if (usuario.getNome().trim().isEmpty() || usuario.getEmail().trim().isEmpty()
		|| usuario.getSenha().trim().isEmpty() || usuario.getDtNascimento() == null)
	    return "Todos os campos são obrigatórios! ";
	return null;
    }

}
