package br.com.infomore.controle.web.vh.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.SenhaUsuario;
import br.com.infomore.dominio.Usuario;

public class SenhaViewHelper implements IViewHelper {

    @Override
    public EntidadeDominio getEntity(HttpServletRequest request) {
	Usuario usuario = null;
	String acao = request.getParameter("acao");

	if (acao != null && acao.equals("alterar")) {

	    usuario = (Usuario) request.getSession().getAttribute("usuario");

	    SenhaUsuario senhaUsuario = new SenhaUsuario();
	    senhaUsuario.setAtualizacaoSenha(true);
	    senhaUsuario.setSenhaAtual(request.getParameter("inputSenhaAtual"));
	    senhaUsuario.setSenhaNova(request.getParameter("inputSenhaNova"));
	    senhaUsuario.setConfirmaSenhaNova(request.getParameter("inputConfirmarSenhaNova"));

	    usuario.setSenhaUsuario(senhaUsuario);
	}
	return usuario;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	String acao = request.getParameter("acao");
	RequestDispatcher d = null;

	if (acao != null && acao.equals("alterar")) {
	    if (resultado == null || resultado.getMsg() == null) {
		request.setAttribute("mensagem", "Senha alterada com sucesso!");
		d = request.getRequestDispatcher("view/mapa.jsp");
	    } else {
		request.setAttribute("mensagem", resultado.getMsg());
		d = request.getRequestDispatcher("view/senha.jsp");
	    }
	} else {
	    d = request.getRequestDispatcher("view/senha.jsp");
	}
	d.forward(request, response);

    }

}
