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
	// este view helper � s� para redirecionamento de p�ginas
	return null;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	// redireciona pra p�gina do mesmo nome do par�metro 'acao' da request
	request.getRequestDispatcher("view/" + request.getParameter("acao") + ".html").forward(request, response);

    }

}
