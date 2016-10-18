package br.com.infomore.controle.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter("/*")
public class Filtro implements Filter {

    /**
     * Default constructor.
     */
    public Filtro() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
	// TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	HttpServletRequest requisicao = (HttpServletRequest) request;
	String uri = requisicao.getRequestURI();
	String acao = requisicao.getParameter("acao");
	// deixar passar a requisição ?
	if (requisicao.getSession().getAttribute("usuario") != null
		|| uri.matches(".*(css|jpg|png|gif|js|woff|woff2|ttf)$")
		|| (uri.contains("/navegar") && "cadastro".equals(acao) || "login".equals(acao))
		|| uri.contains("/cadastro") || uri.contains("/login")) {
	    chain.doFilter(request, response); // deixa passar a request
	} else {
	    // redireciona para o login
	    requisicao.getRequestDispatcher("view/login.jsp").forward(request, response);
	}
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
	// TODO Auto-generated method stub
    }

}
