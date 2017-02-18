package br.com.infomore.controle.web.vh.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.controle.web.view.ClassificacaoView;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.Categoria;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Prioridade;
import br.com.infomore.dominio.Usuario;

/**
 * Classe responsável por construir o objeto que irá ser utilizado para
 * atualizar as definições da classificação (prioridades) das categorias
 * disponíveis no sistema, além de servir a página correta após as operações
 * 
 * @author José Roberto
 *
 */
public class ClassificacaoViewHelper implements IViewHelper {
    private ServletContext contexto;
    private final static String ATRIBUTO_CATEGORIAS = "categorias";
    private final static String ATRIBUTO_USUARIO = "usuario";

    private final static Integer ID_SAUDE = 0;
    private final static Integer ID_EDUCACAO = 1;
    private final static Integer ID_SEGURANCA = 2;
    private final static Integer ID_COMODIDADE = 3;
    private final static Integer ID_LAZER = 4;
    private final static Integer ID_TRANSPORTE = 5;
    private final static Integer ID_OCORRENCIA = 6;

    public ClassificacaoViewHelper(ServletContext contexto) {
	this.contexto = contexto;
    }

    @Override
    public EntidadeDominio getEntity(HttpServletRequest request) {

	// pega o usuário da sessão
	Usuario usuario = (Usuario) request.getSession().getAttribute(ATRIBUTO_USUARIO);

	// pegar as prioridades classificadas pelo usuário e associá-las ao seu perfil, utilizando 
	// também as classificações armazenadas no contexto

	Prioridade prioridadeSaude = new Prioridade();
	Prioridade prioridadeEducacao = new Prioridade();
	Prioridade prioridadeSeguranca = new Prioridade();
	Prioridade prioridadeComodidade = new Prioridade();
	Prioridade prioridadeLazer = new Prioridade();
	Prioridade prioridadeTransporte = new Prioridade();
	Prioridade prioridadeOcorrencia = new Prioridade();

	List<Categoria> categorias = (List<Categoria>) contexto.getAttribute(ATRIBUTO_CATEGORIAS);

	prioridadeSaude.setPeso(Double.parseDouble(request.getParameter(ClassificacaoView.INPUT_SAUDE)));
	prioridadeSaude.setCategoria(categorias.get(ID_SAUDE));
	prioridadeSaude.setDescricao(categorias.get(ID_SAUDE).getDescricao());
	prioridadeSaude.setUsuario(usuario);

	prioridadeEducacao.setPeso(Double.parseDouble(request.getParameter(ClassificacaoView.INPUT_EDUCACAO)));
	prioridadeEducacao.setCategoria(categorias.get(ID_EDUCACAO));
	prioridadeEducacao.setDescricao(categorias.get(ID_EDUCACAO).getDescricao());
	prioridadeEducacao.setUsuario(usuario);

	prioridadeSeguranca.setPeso(Double.parseDouble(request.getParameter(ClassificacaoView.INPUT_SEGURANCA)));
	prioridadeSeguranca.setCategoria(categorias.get(ID_SEGURANCA));
	prioridadeSeguranca.setDescricao(categorias.get(ID_SEGURANCA).getDescricao());
	prioridadeSeguranca.setUsuario(usuario);

	prioridadeComodidade.setPeso(Double.parseDouble(request.getParameter(ClassificacaoView.INPUT_COMODIDADES)));
	prioridadeComodidade.setCategoria(categorias.get(ID_COMODIDADE));
	prioridadeComodidade.setDescricao(categorias.get(ID_COMODIDADE).getDescricao());
	prioridadeComodidade.setUsuario(usuario);

	prioridadeLazer.setPeso(Double.parseDouble(request.getParameter(ClassificacaoView.INPUT_LAZER)));
	prioridadeLazer.setCategoria(categorias.get(ID_LAZER));
	prioridadeLazer.setDescricao(categorias.get(ID_LAZER).getDescricao());
	prioridadeLazer.setUsuario(usuario);

	prioridadeTransporte.setPeso(Double.parseDouble(request.getParameter(ClassificacaoView.INPUT_TRANSPORTE)));
	prioridadeTransporte.setCategoria(categorias.get(ID_TRANSPORTE));
	prioridadeTransporte.setDescricao(categorias.get(ID_TRANSPORTE).getDescricao());
	prioridadeTransporte.setUsuario(usuario);

	prioridadeOcorrencia.setPeso(Double.parseDouble(request.getParameter(ClassificacaoView.INPUT_OCORRENCIAS)));
	prioridadeOcorrencia.setCategoria(categorias.get(ID_OCORRENCIA));
	prioridadeOcorrencia.setDescricao(categorias.get(ID_OCORRENCIA).getDescricao());
	prioridadeOcorrencia.setUsuario(usuario);

	List<Prioridade> prioridades = new ArrayList<>();
	prioridades.add(prioridadeOcorrencia);
	prioridades.add(prioridadeComodidade);
	prioridades.add(prioridadeEducacao);
	prioridades.add(prioridadeLazer);
	prioridades.add(prioridadeSaude);
	prioridades.add(prioridadeSeguranca);
	prioridades.add(prioridadeTransporte);

	usuario.setPrioridades(prioridades);
	usuario.setExecutarWizard(false); // para não entrar automaticamente em classificações no próximo login

	return usuario;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	RequestDispatcher d = request.getRequestDispatcher("view/local.jsp");

	d.forward(request, response);
    }

}
