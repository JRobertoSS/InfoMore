package br.com.infomore.controle.web.vh.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Ponto;

public class MapaViewHelper implements IViewHelper {

    @Override
    public EntidadeDominio getEntity(HttpServletRequest request) {

	String acao = request.getParameter("acao");
	Ponto ponto = new Ponto();

	if (acao.equals("meulocal")) {
	    request.setAttribute("local", ponto);
	} else if (acao.equals("escolherLocal")) {
	    ponto = new Ponto();
	    // depois aqui será definido o ponto inicial escolhido pelo usuario
	}
	return null;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {

	request.getRequestDispatcher("view/mapa.jsp").forward(request, response);

    }

}
