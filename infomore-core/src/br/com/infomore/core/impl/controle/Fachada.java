package br.com.infomore.core.impl.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.infomore.core.impl.dao.AbstractDAO;
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
	private Map<String, AbstractDAO> daos;
	
	/**
	 * Mapa para conter as regras de negócio de todas operações por entidade;
	 * O valor é um mapa que de regras de negócio indexado pela operação
	 */
	private Map<String, Map<String, List<IStrategy>>> rns;
	
	private Resultado resultado;
	
	
	public Fachada(){
		/* Intânciando o Map de DAOS */
		daos = new HashMap<String, AbstractDAO>();
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
		UsuarioDAO uDao = new UsuarioDAO();
		Usuario consulta = uDao.consultarPorEmail(usuario.getEmail());
	
		if (consulta != null){
			List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
			lista.add(consulta);
			resultado.setEntidades(lista);
		}else{
			resultado.setMsg("E-mail inválido, ou Usuário inexistente!");
			return resultado;
		}
		
		if(!consulta.getSenha().equals(usuario.getSenha()))
			resultado.setMsg("Senha inválida!");
		return resultado;
	}
	
	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "salvar"); // validações
		
		
		if(msg == null){
			AbstractDAO dao = daos.get(nmClasse);
			dao.salvar(entidade);
			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
			entidades.add(entidade);
			resultado.setEntidades(entidades);
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
			AbstractDAO dao = daos.get(nmClasse);
			dao.alterar(entidade);
			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
			entidades.add(entidade);
			resultado.setEntidades(entidades);
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
			AbstractDAO dao = daos.get(nmClasse);
			dao.excluir(entidade);
			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
			entidades.add(entidade);
			resultado.setEntidades(entidades);
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;

	}

	@Override
	public Resultado listar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "listar");
		
		
		if(msg == null){
			AbstractDAO dao = daos.get(nmClasse);
			resultado.setEntidades(dao.listar());
		}else{
			resultado.setMsg(msg);
			
		}
		
		return resultado;

	}
	
	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		resultado = new Resultado();
		resultado.setEntidades(new ArrayList<EntidadeDominio>(1));
		
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "consultar");
		
		List<EntidadeDominio> consulta = new ArrayList<EntidadeDominio>();
		
		if(msg == null){
			AbstractDAO dao = daos.get(nmClasse);
			consulta.add((EntidadeDominio)dao.consultarPorChave(entidade.getId()));
		}else{
			resultado.setMsg(msg);	
		}
			
		resultado.setEntidades(consulta);		
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
