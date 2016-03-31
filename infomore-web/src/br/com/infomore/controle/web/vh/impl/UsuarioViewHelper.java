package br.com.infomore.controle.web.vh.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.Usuario;

public class UsuarioViewHelper implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("txtNome"));
		usuario.setEmail(request.getParameter("txtEmail"));
		usuario.setSenha(request.getParameter("txtSenha"));
		
		return usuario;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		RequestDispatcher d = null;

		String acao = request.getParameter("acao");

		if (resultado.getMsg() == null) {
			if (acao.equals("salvar")) {
				resultado.setMsg("Cadastrado com sucesso!");
				d = request.getRequestDispatcher("/login.jsp");
			}
			if (acao.equals("alterar")) {
				resultado.setMsg("Alterado com sucesso!");
				d = request.getRequestDispatcher("/user/perfil.jsp"); //futuro perfil
			}
			if (acao.equals("excluir")) 
				resultado.setMsg("Excluído com sucesso!");
	
			
			if (acao.equals("visualizar")) 
				request.setAttribute("usuario", resultado.getEntidades().get(0));
			
			if (acao.equals("login")) {
				Usuario usuario = (Usuario) resultado.getEntidades().get(0);
				request.getSession().setAttribute("usuario", usuario);
				if(usuario.getExecutarWizard())
					d = request.getRequestDispatcher("/user/classificacao.jsp");
				else
					d = request.getRequestDispatcher("/user/local.jsp");
			}
			if(acao.equals("consultar"))
				request.setAttribute("usuarios", resultado.getEntidades());
		
			
		
		} else{
			if (acao.equals("salvar")) 
				d = request.getRequestDispatcher("/cadastro.jsp");
			
			if (acao.equals("alterar") || acao.equals("excluir")) 
				d = request.getRequestDispatcher("futuraPaginaDoUsuario.jsp"); // edição de perfil
			
			if (acao.equals("login")) 
				d = request.getRequestDispatcher("/login.jsp");
			
			
		}
		request.setAttribute("resultado", resultado);
		d.forward(request, response);

	}

}
