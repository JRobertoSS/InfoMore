package br.com.infomore.controle.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.infomore.controle.web.command.ICommand;
import br.com.infomore.controle.web.command.impl.AlterarCommand;
import br.com.infomore.controle.web.command.impl.ConsultarCommand;
import br.com.infomore.controle.web.command.impl.ExcluirCommand;
import br.com.infomore.controle.web.command.impl.LoginCommand;
import br.com.infomore.controle.web.command.impl.SalvarCommand;
import br.com.infomore.controle.web.command.impl.VisualizarCommand;
import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.controle.web.vh.impl.UsuarioViewHelper;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Usuario;

/**
 * Servlet implementation class Servlet
 */
public class ServletMapa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    		IOException {
    	
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		if(request.getParameter("local") != null && request.getParameter("local").equals("meulocal")){
			request.getRequestDispatcher("/user/mapa.jsp").forward(request, response);
		}
		
		if(request.getParameter("acao") != null && request.getParameter("acao").equals("classificacao") 
				&& usuario.getExecutarWizard()){
			// salvar as classificações do usuário e encaminhar para o meu local
			request.getRequestDispatcher("/user/local.jsp").forward(request, response);
		}
		
		if(request.getParameter("acao") != null && request.getParameter("acao").equals("classificacao") 
				&& !usuario.getExecutarWizard()){
			// encaminhar para o mapa
			request.getRequestDispatcher("/user/mapa.jsp").forward(request, response);
		}
	}
	
	
}
