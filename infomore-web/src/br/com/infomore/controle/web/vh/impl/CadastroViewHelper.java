package br.com.infomore.controle.web.vh.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.controle.web.view.util.FormatadorUtil;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Usuario;

public class CadastroViewHelper implements IViewHelper {

    @Override
    public EntidadeDominio getEntity(HttpServletRequest request) {

	Usuario usuario = new Usuario();
	usuario.setNome(request.getParameter("inputNome"));
	usuario.setEmail(request.getParameter("inputEmail"));
	usuario.setSenha(request.getParameter("inputSenha"));
	usuario.setExecutarWizard(true);

	String dataString = request.getParameter("inputData");
	if (dataString != null)
	    usuario.setDtNascimento(FormatadorUtil.formataStringParaDate(dataString));

	return usuario;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	RequestDispatcher d = null;

	if (resultado != null && resultado.getMsg() != null)
	    d = request.getRequestDispatcher("view/cadastro.jsp");
	else {
	    resultado.setMsg("Cadastro realizado com sucesso!");
	    d = request.getRequestDispatcher("view/login.jsp");
	}
	request.setAttribute("mensagem", resultado.getMsg());
	d.forward(request, response);
    }

}
