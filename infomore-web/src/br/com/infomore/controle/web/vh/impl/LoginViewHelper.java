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
	Usuario usuario = new Usuario();
	usuario.setEmail(request.getParameter("inputEmail"));
	usuario.setSenha(request.getParameter("inputSenha"));
	return usuario;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {
	RequestDispatcher d = null;

	Usuario usuario = resultado.getEntidades().isEmpty() ? null : (Usuario) resultado.getEntidades().get(0);

	if (usuario == null) { // n�o encontrou o usu�rio por e-mail?

	    resultado.setMsg("Usuario n�o cadastrado!");
	    d = request.getRequestDispatcher("view/login.jsp");

	} else { // encontrou

	    if (usuario.getSenha().equals(request.getParameter("inputSenha"))) { // a senha digitada corresponde � cadastrada?

		request.getSession().setAttribute("usuario", usuario); // seta usu�rio na sess�o 

		if (usuario.isExecutarWizard()) { // � para executar a classifica��o?
		    d = request.getRequestDispatcher("view/classificacao.jsp");
		} else { // sen�o vai para escolha do local
		    d = request.getRequestDispatcher("view/local.jsp");
		}

	    } else { // senha inv�lida 
		resultado.setMsg("Senha inv�lida!");
		d = request.getRequestDispatcher("view/login.jsp");
	    }
	}

	request.setAttribute("resultado", resultado);
	d.forward(request, response);

    }

}
