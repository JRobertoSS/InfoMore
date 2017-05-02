package br.com.infomore.controle.web.vh.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import br.com.infomore.dominio.CompararLocais;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.LimiteRaio;
import br.com.infomore.dominio.MeuLocal;
import br.com.infomore.dominio.Ponto;
import br.com.infomore.dominio.Usuario;

public class MeusLocaisViewHelper implements IViewHelper {

	@Override
	public EntidadeDominio getEntity(HttpServletRequest request) {

		if (request.getParameter("acao").equals("comparar")) {
			String[] checkboxes = request.getParameterValues("checkComparar");
			
			CompararLocais compararLocais = new CompararLocais();
			compararLocais.setIdsComparacao(new ArrayList<String>());
			
			if(checkboxes.length > 0){
				for(String id : checkboxes){
					compararLocais.getIdsComparacao().add(id);
				}
				
			}
			// baseado nessa entidade, irá pesquisar os ids (strings) dos locais para comparar
			return compararLocais;
		}
		
		MeuLocal meuLocal = new MeuLocal();
		meuLocal.setUsuario((Usuario) request.getSession().getAttribute("usuario"));
		return meuLocal;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher d = null;
		
		if (request.getParameter("acao").equals("listar"))
			request.setAttribute("meusLocais", resultado.getEntidades());
		
		d = request.getRequestDispatcher("view/meusLocais.jsp");

		d.forward(request, response);
	}

}
