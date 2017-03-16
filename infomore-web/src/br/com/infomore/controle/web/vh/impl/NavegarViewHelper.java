package br.com.infomore.controle.web.vh.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;

public class NavegarViewHelper implements IViewHelper {

    @Override
    public EntidadeDominio getEntity(HttpServletRequest request) {
	// este view helper é só para redirecionamento de páginas
	return null;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	String acao = request.getParameter("acao");

	if (acao == null || acao.isEmpty())
	    acao = "login";

	// redireciona pra página do mesmo nome do parâmetro 'acao' da request
	request.getRequestDispatcher("view/" + acao + ".jsp").forward(request, response);

    }

}
