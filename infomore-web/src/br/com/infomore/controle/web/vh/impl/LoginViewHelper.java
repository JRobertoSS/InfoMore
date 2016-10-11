package br.com.infomore.controle.web.vh.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Usuario;

public class LoginViewHelper implements IViewHelper {

	@Override
	public EntidadeDominio getEntity(HttpServletRequest request) {
		return null;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		RequestDispatcher d = null;
		String acao = request.getParameter("acao");
		
		request.setAttribute("resultado", resultado);
		d.forward(request, response);

	}

}
