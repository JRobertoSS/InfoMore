package br.com.infomore.controle.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.infomore.controle.web.command.ICommand;
import br.com.infomore.controle.web.command.impl.AlterarCommand;
import br.com.infomore.controle.web.command.impl.ConsultarCommand;
import br.com.infomore.controle.web.command.impl.ExcluirCommand;
import br.com.infomore.controle.web.command.impl.SalvarCommand;
import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.controle.web.vh.impl.CadastroViewHelper;
import br.com.infomore.controle.web.vh.impl.LoginViewHelper;
import br.com.infomore.controle.web.vh.impl.NavegarViewHelper;
import br.com.infomore.controle.web.vh.impl.PerfilViewHelper;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Map<String, ICommand> commands;
    private static Map<String, IViewHelper> vhs;

    public Servlet() {

	/*
	 * Utilizando o command para chamar a fachada e indexando cada command
	 * pela opera��o garantimos que esta servelt atender� qualquer opera��o
	 */
	commands = new HashMap<String, ICommand>();

	commands.put("salvar", new SalvarCommand());
	commands.put("alterar", new AlterarCommand());
	commands.put("excluir", new ExcluirCommand());
	commands.put("consultar", new ConsultarCommand());

	/*
	 * Utilizando o ViewHelper para tratar especifica��es de qualquer tela e
	 * indexando cada viewhelper pela url em que esta servlet � chamada no
	 * form garantimos que esta servelt atender� qualquer entidade
	 */

	vhs = new HashMap<String, IViewHelper>();
	/*
	 * A chave do mapa � o mapeamento da servlet para cada form que est�
	 * configurado no web.xml e sendo utilizada no action do html
	 */
	vhs.put("/infomore/navegar", new NavegarViewHelper());
	vhs.put("/infomore/login", new LoginViewHelper());
	vhs.put("/infomore/cadastro", new CadastroViewHelper());
	vhs.put("/infomore/perfil", new PerfilViewHelper());

    }

    /**
     * TODO Descri��o do M�todo
     * 
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doProcessRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	doProcessRequest(request, response);
    }

    protected void doProcessRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	// Obt�m a uri que invocou esta servlet (O que foi definido no method do
	// form html)
	String uri = request.getRequestURI();

	// Obt�m a opera��o executada
	String acao = request.getParameter("acao");

	// Obt�m um viewhelper indexado pela uri que invocou esta servlet
	IViewHelper vh = vhs.get(uri);

	// O viewhelper retorna a entidade especifica para a tela que chamou
	// esta servlet
	EntidadeDominio entidade = vh.getEntity(request);

	// Obt�m o command para executar a respectiva opera��o
	ICommand command = commands.get(acao);

	/*
	 * Executa o command que chamar� a fachada para executar a opera��o
	 * requisitada o retorno � uma inst�ncia da classe resultado que pode
	 * conter mensagens derro ou entidades de retorno
	 */
	Resultado resultado = null;
	if (entidade != null)
	    resultado = command.execute(entidade);

	/*
	 * Executa o m�todo setView do view helper espec�fico para definir como
	 * dever� ser apresentado o resultado para o usu�rio
	 */
	vh.setView(resultado, request, response);

    }
}
