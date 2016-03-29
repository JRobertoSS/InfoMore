package br.com.infomore.core.impl.controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.infomore.core.IDAO;
import br.com.infomore.core.IFachada;
import br.com.infomore.core.IStrategy;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.core.impl.dao.UsuarioDAO;
import br.com.infomore.core.impl.negocio.ValidaCamposVazios;
import br.com.infomore.core.impl.negocio.ValidadorEmailUnico;

import br.com.infomore.dominio.Usuario;
import br.com.infomore.dominio.EntidadeDominio;


public class Fachada implements IFachada {

	/** 
	 * Mapa de DAOS, será indexado pelo nome da entidade 
	 * O valor é uma instância do DAO para uma dada entidade; 
	 */
	private Map<String, IDAO> daos;
	
	/**
	 * Mapa para conter as regras de negócio de todas operações por entidade;
	 * O valor é um mapa que de regras de negócio indexado pela operação
	 */
	private Map<String, Map<String, List<IStrategy>>> rns;
	
	private Resultado resultado;
	
	
	public Fachada(){
		/* Intânciando o Map de DAOS */
		daos = new HashMap<String, IDAO>();
		/* Intânciando o Map de Regras de Negócio */
		rns = new HashMap<String, Map<String, List<IStrategy>>>();
		
		/* Criando instâncias dos DAOs a serem utilizados*/	
		UsuarioDAO usuarioDao = new UsuarioDAO();

		
		/* Adicionando cada dao no MAP indexando pelo nome da classe */
		daos.put(Usuario.class.getName(), usuarioDao);		

		
		// RNS A PARTIR DAQUI (implementar)
		/* Criando instâncias de regras de negócio a serem utilizados*/		
		ValidadorEmailUnico validaEmail = new ValidadorEmailUnico();
		ValidaCamposVazios validaCampos = new ValidaCamposVazios();


		/* Criando uma lista para conter as regras de negócio
		 * quando a operação for salvar
		 */
		List<IStrategy> rnsSalvarUsuario = new ArrayList<IStrategy>();
		/* Adicionando as regras a serem utilizadas na operação salvar ou alterar */
		rnsSalvarUsuario.add(validaEmail);
		rnsSalvarUsuario.add(validaCampos);
				
		
		/* Cria o mapa que poderá conter todas as listas de regras de negócio específica 
		 * por operação  do fabricante
		 */
		Map<String, List<IStrategy>> rnsUsuario = new HashMap<String, List<IStrategy>>();
		/*
		 * Adiciona a listra de regras na operação salvar no mapa do fabricante 
		 */
		rnsUsuario.put("salvar", rnsSalvarUsuario);
		rnsUsuario.put("alterar", rnsSalvarUsuario);

		
		/* Adiciona o mapa com as regras indexadas pelas operações no mapa geral indexado 
		 * pelo nome da entidade
		 */
		rns.put(Usuario.class.getName(), rnsUsuario);
	}
	
	public Resultado login(EntidadeDominio entidade){
		resultado = new Resultado();
		
		Usuario usuario = (Usuario) entidade;
		UsuarioDAO uDAO = new UsuarioDAO();
		List<EntidadeDominio> consulta = uDAO.consultar(usuario);
	
		if (!consulta.isEmpty())
			resultado.setEntidades(consulta);
		else{
			resultado.setMsg("E-mail inválido, ou Usuário inexistente!");
			return resultado;
		}
		Usuario usuarioConsulta = (Usuario) consulta.get(0);
		if(!usuario.getSenha().equals(usuarioConsulta.getSenha()))
			resultado.setMsg("Senha inválida!");
		return resultado;
	}
	
	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "salvar"); // validações
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.salvar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar o registro!");
			}
		}else{
			resultado.setMsg(msg);
		}
		return resultado;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "alterar");
	
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.alterar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;

	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "excluir");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.excluir(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;

	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "consultar");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				
				resultado.setEntidades(dao.consultar(entidade));
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar a consulta!");
				
			}
		}else{
			resultado.setMsg(msg);
			
		}
		
		return resultado;

	}
	
	@Override
	public Resultado visualizar(EntidadeDominio entidade) {
		resultado = new Resultado();
		resultado.setEntidades(new ArrayList<EntidadeDominio>(1));
		resultado.getEntidades().add(entidade);		
		return resultado;

	}

	
	private String executarRegras(EntidadeDominio entidade, String operacao){
		String nmClasse = entidade.getClass().getName();		
		StringBuilder msg = new StringBuilder();
		
		Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);
		
		
		if(regrasOperacao != null){
			List<IStrategy> regras = regrasOperacao.get(operacao);
			
			if(regras != null){
				for(IStrategy s: regras){			
					String m = s.processar(entidade);			
					
					if(m != null){
						msg.append(m);
						msg.append("\n");
					}			
				}	
			}			
			
		}
		
		if(msg.length()>0)
			return msg.toString();
		else
			return null;
	}
}
