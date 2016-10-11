package br.com.infomore.controle.web.vh.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Usuario;

public class PerfilViewHelper implements IViewHelper {

    @Override
    public EntidadeDominio getEntity(HttpServletRequest request) {
	Usuario usuario = new Usuario();
	usuario.setNome(request.getParameter("txtNome"));
	usuario.setEmail(request.getParameter("txtEmail"));
	usuario.setSenha(request.getParameter("txtSenha"));

	return usuario;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {

    }

}
