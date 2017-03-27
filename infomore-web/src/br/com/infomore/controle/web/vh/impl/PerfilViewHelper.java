package br.com.infomore.controle.web.vh.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.controle.web.view.TipoMensagemView;
import br.com.infomore.controle.web.view.util.FormatadorUtil;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.SenhaUsuario;
import br.com.infomore.dominio.Usuario;

public class PerfilViewHelper implements IViewHelper {

	@Override
	public EntidadeDominio getEntity(HttpServletRequest request) {
		String acao = request.getParameter("acao");

		if (acao != null && acao.equals("consultar")) {
			return (Usuario) request.getSession().getAttribute("usuario");
		}

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		usuario.setNome(request.getParameter("inputNome"));
		usuario.setEmail(request.getParameter("inputEmail"));

		String dataString = request.getParameter("inputData");
		usuario.setDtNascimento(FormatadorUtil.formataStringParaDate(dataString));
		
		SenhaUsuario senhaUsuario = new SenhaUsuario();
		senhaUsuario.setConfirmaSenhaNova( request.getParameter("inputConfirmarSenha")); // para autorizar a alteração de perfil
		senhaUsuario.setSenhaNova(usuario.getSenha()); // será utilizado para confirmar a senha (junto do confirmarSenhaNova)
		
		usuario.setSenhaUsuario(senhaUsuario);

		return usuario;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String acao = request.getParameter("acao");
		RequestDispatcher d = null;

		request.setAttribute("formatador", new FormatadorUtil());

		if (acao != null && acao.equals("alterarPerfil")) {
			if (resultado == null || resultado.getMsg() == null) {
				request.setAttribute("mensagem", "Perfil atualizado com sucesso!");
				request.setAttribute("tipoMensagem", TipoMensagemView.MSG_SUCESSO);
				d = request.getRequestDispatcher("view/mapa.jsp");
			} else {
				request.setAttribute("mensagem", resultado.getMsg());
				request.setAttribute("tipoMensagem", TipoMensagemView.MSG_ALERTA);
				request.setAttribute("usuario", request.getSession().getAttribute("usuario"));
				d = request.getRequestDispatcher("view/perfil.jsp");
			}
		} else {
			d = request.getRequestDispatcher("view/perfil.jsp");
		}
		d.forward(request, response);

	}

}
