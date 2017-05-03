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

public class MeuLocalViewHelper implements IViewHelper {

	@Override
	public EntidadeDominio getEntity(HttpServletRequest request) {

		MeuLocal meuLocal = (MeuLocal) request.getSession().getAttribute("meuLocal");
		meuLocal.setNome(request.getParameter("inputNome"));
		meuLocal.setDescricao(request.getParameter("inputDescricao"));

		request.getSession().setAttribute("meuLocal", meuLocal);

		return meuLocal;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String acao = request.getParameter("acao");
		RequestDispatcher d = null;

		if (acao.equals("salvar")) {
			if (resultado.getMsg() == null) {
				request.setAttribute("mensagem", "Local salvo com sucesso!");
				request.setAttribute("tipoMensagem", TipoMensagemView.MSG_SUCESSO);
				request.getSession().setAttribute("meuLocal", null);
				d = request.getRequestDispatcher("view/mapa.jsp");
			} else {
				request.setAttribute("mensagem", resultado.getMsg());
				request.setAttribute("tipoMensagem", TipoMensagemView.MSG_ALERTA);
				d = request.getRequestDispatcher("view/detalhesMeuLocal.jsp");
			}
		}
		if(acao.equals("alterar")){
			if (resultado.getMsg() == null) {
				request.setAttribute("mensagem", "Local salvo com sucesso!");
				request.setAttribute("tipoMensagem", TipoMensagemView.MSG_SUCESSO);
				request.getSession().setAttribute("meuLocal", null);
				d = request.getRequestDispatcher("/meusLocais?acao=listar");
			} else {
				request.setAttribute("mensagem", resultado.getMsg());
				request.setAttribute("tipoMensagem", TipoMensagemView.MSG_ALERTA);
				d = request.getRequestDispatcher("view/editarMeuLocal.jsp");
			}
		}
		d.forward(request, response);
	}

}
