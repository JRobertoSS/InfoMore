package br.com.infomore.controle.web.vh.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.controle.web.view.TipoMensagemView;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.Categoria;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.LimiteRaio;
import br.com.infomore.dominio.MeuLocal;
import br.com.infomore.dominio.Ponto;

public class EditarLocalViewHelper implements IViewHelper {

	@Override
	public EntidadeDominio getEntity(HttpServletRequest request) {

		MeuLocal meuLocal = new MeuLocal();
		meuLocal.setId(Integer.valueOf(request.getParameter("idLocal")));
		return meuLocal;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher d = null;
		if (resultado.getMsg() == null && ! resultado.getEntidades().isEmpty()) {
			request.getSession().setAttribute("meuLocal", resultado.getEntidades().get(0));
			d = request.getRequestDispatcher("view/editarMeuLocal.jsp"); 
		} else {
			request.setAttribute("mensagem", resultado.getMsg());
			request.setAttribute("tipoMensagem", TipoMensagemView.MSG_ALERTA);
			d = request.getRequestDispatcher("/meusLocais?acao=listar");
		}
		d.forward(request, response);
	}

}
