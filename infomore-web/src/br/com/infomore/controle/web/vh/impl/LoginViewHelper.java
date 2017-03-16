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
	String acao = request.getParameter("acao");

	if (acao != null && acao.equals("sair"))
	    return null;

	Usuario usuario = new Usuario();
	usuario.setEmail(request.getParameter("inputEmail"));
	usuario.setSenha(request.getParameter("inputSenha"));
	return usuario;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	String acao = request.getParameter("acao");
	RequestDispatcher d = null;

	if (acao != null && acao.equals("sair")) {

	    request.getSession().setAttribute("usuario", null);
	    d = request.getRequestDispatcher("view/login.jsp");

	} else {

	    Usuario usuario = resultado.getEntidades().isEmpty() ? null : (Usuario) resultado.getEntidades().get(0);

	    if (resultado != null && resultado.getMsg() != null) {

		request.setAttribute("mensagem", resultado.getMsg());
		d = request.getRequestDispatcher("view/login.jsp");

	    } else if (usuario == null) { // não encontrou o usuário por e-mail?

		request.setAttribute("mensagem", "Usuario não cadastrado!");
		d = request.getRequestDispatcher("view/login.jsp");

	    } else { // encontrou

		if (usuario.getSenha().equals(request.getParameter("inputSenha"))) { // a senha digitada corresponde à cadastrada?

		    request.getSession().setAttribute("usuario", usuario); // seta usuário na sessão 

		    if (usuario.isExecutarWizard()) { // é para executar a classificação?
			d = request.getRequestDispatcher("view/classificacao.jsp");
		    } else { // senão vai para o mapa
			d = request.getRequestDispatcher("view/mapa.jsp");
		    }

		} else { // senha inválida 
		    request.setAttribute("mensagem", "Senha inválida!");
		    d = request.getRequestDispatcher("view/login.jsp");
		}
	    }
	}
	request.setAttribute("resultado", resultado);
	d.forward(request, response);

    }

}
