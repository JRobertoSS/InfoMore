package br.com.infomore.core.impl.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.infomore.core.IFachada;
import br.com.infomore.core.IStrategy;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.core.impl.dao.AbstractDAO;
import br.com.infomore.core.impl.dao.CategoriaDAO;
import br.com.infomore.core.impl.dao.LimiteRaioDAO;
import br.com.infomore.core.impl.dao.PontoDAO;
import br.com.infomore.core.impl.dao.UsuarioDAO;
import br.com.infomore.core.impl.negocio.ValidaCamposVazios;
import br.com.infomore.core.impl.negocio.ValidadorEmailUnico;
import br.com.infomore.dominio.Categoria;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Ponto;
import br.com.infomore.dominio.Usuario;
import br.com.infomore.dominio.json.LimiteRaio;

public class Fachada implements IFachada {

    /**
     * Mapa de DAOS, ser� indexado pelo nome da entidade O valor � uma inst�ncia
     * do DAO para uma dada entidade;
     */
    private Map<String, AbstractDAO> daos;

    /**
     * Mapa para conter as regras de neg�cio de todas opera��es por entidade; O
     * valor � um mapa que de regras de neg�cio indexado pela opera��o
     */
    private Map<String, Map<String, List<IStrategy>>> rns;

    private Resultado resultado;

    public Fachada() {
	/* Instanci�ndo o Map de DAOS */
	daos = new HashMap<String, AbstractDAO>();
	/* Instanci�ndo o Map de Regras de Neg�cio */
	rns = new HashMap<String, Map<String, List<IStrategy>>>();

	/* Criando inst�ncias dos DAOs a serem utilizados */
	UsuarioDAO usuarioDao = new UsuarioDAO();
	CategoriaDAO categoriaDao = new CategoriaDAO();
	PontoDAO pontoDao = new PontoDAO();
	LimiteRaioDAO limiteRaioDao = new LimiteRaioDAO();

	/* Adicionando cada dao no MAP indexando pelo nome da classe */
	daos.put(Usuario.class.getName(), usuarioDao);
	daos.put(Categoria.class.getName(), categoriaDao);
	daos.put(Ponto.class.getName(), pontoDao);
	daos.put(LimiteRaio.class.getName(), limiteRaioDao);

	// RNS A PARTIR DAQUI (implementar)
	/* Criando inst�ncias de regras de neg�cio a serem utilizados */
	ValidadorEmailUnico validaEmail = new ValidadorEmailUnico();
	ValidaCamposVazios validaCampos = new ValidaCamposVazios();

	/*
	 * Criando uma lista para conter as regras de neg�cio quando a opera��o
	 * for salvar
	 */
	List<IStrategy> rnsSalvarUsuario = new ArrayList<IStrategy>();
	/*
	 * Adicionando as regras a serem utilizadas na opera��o salvar
	 */
	rnsSalvarUsuario.add(validaEmail);
	rnsSalvarUsuario.add(validaCampos);

	/*
	 * Criando uma lista para conter as regras de neg�cio quando a opera��o
	 * for salvar
	 */
	List<IStrategy> rnsAlterarUsuario = new ArrayList<IStrategy>();
	/*
	 * Adicionando as regras a serem utilizadas na opera��o alterar
	 */

	rnsAlterarUsuario.add(validaCampos);

	/*
	 * Cria o mapa que poder� conter todas as listas de regras de neg�cio
	 * espec�fica por opera��o do fabricante
	 */
	Map<String, List<IStrategy>> rnsUsuario = new HashMap<String, List<IStrategy>>();
	/*
	 * Adiciona a listra de regras na opera��o salvar no mapa do fabricante
	 */
	rnsUsuario.put("salvar", rnsSalvarUsuario);
	rnsUsuario.put("alterar", rnsAlterarUsuario);

	/*
	 * Adiciona o mapa com as regras indexadas pelas opera��es no mapa geral
	 * indexado pelo nome da entidade
	 */
	rns.put(Usuario.class.getName(), rnsUsuario);
    }

    @Override
    public Resultado salvar(EntidadeDominio entidade) {
	resultado = new Resultado();
	String nmClasse = entidade.getClass().getName();

	String msg = executarRegras(entidade, "salvar"); // valida��es

	if (msg == null) {
	    AbstractDAO dao = daos.get(nmClasse);
	    dao.salvar(entidade);
	    List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
	    entidades.add(entidade);
	    resultado.setEntidades(entidades);
	} else {
	    resultado.setMsg(msg);
	}
	return resultado;
    }

    @Override
    public Resultado alterar(EntidadeDominio entidade) {
	resultado = new Resultado();
	String nmClasse = entidade.getClass().getName();

	String msg = executarRegras(entidade, "alterar");

	if (msg == null) {
	    AbstractDAO dao = daos.get(nmClasse);
	    dao.alterar(entidade);
	    List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
	    entidades.add(entidade);
	    resultado.setEntidades(entidades);
	} else {
	    resultado.setMsg(msg);

	}

	return resultado;

    }

    @Override
    public Resultado excluir(EntidadeDominio entidade) {
	resultado = new Resultado();
	String nmClasse = entidade.getClass().getName();

	String msg = executarRegras(entidade, "excluir");

	if (msg == null) {
	    AbstractDAO dao = daos.get(nmClasse);
	    dao.excluir(entidade);
	    List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
	    entidades.add(entidade);
	    resultado.setEntidades(entidades);
	} else {
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

	if (msg == null) {
	    AbstractDAO<Integer, EntidadeDominio> dao = daos.get(nmClasse);
	    consulta.add((EntidadeDominio) dao.consultar(entidade, entidade.getId()));
	} else {
	    resultado.setMsg(msg);
	}

	resultado.setEntidades(consulta);
	return resultado;

    }

    @Override
    public Resultado listar(EntidadeDominio entidade) {
	resultado = new Resultado();
	resultado.setEntidades(new ArrayList<EntidadeDominio>(1));

	String nmClasse = entidade.getClass().getName();

	String msg = executarRegras(entidade, "consultar");

	List<EntidadeDominio> consulta = new ArrayList<EntidadeDominio>();

	if (msg == null) {
	    AbstractDAO<Integer, EntidadeDominio> dao = daos.get(nmClasse);

	    consulta = dao.listar(entidade);

	} else {
	    resultado.setMsg(msg);
	}

	resultado.setEntidades(consulta);
	return resultado;

    }

    private String executarRegras(EntidadeDominio entidade, String operacao) {
	String nmClasse = entidade.getClass().getName();
	StringBuilder msg = new StringBuilder();

	Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);

	if (regrasOperacao != null) {
	    List<IStrategy> regras = regrasOperacao.get(operacao);

	    if (regras != null) {
		for (IStrategy s : regras) {
		    String m = s.processar(entidade);

		    if (m != null) {
			msg.append(m);
			msg.append("\n");
		    }
		}
	    }

	}

	if (msg.length() > 0)
	    return msg.toString();
	else
	    return null;
    }
}