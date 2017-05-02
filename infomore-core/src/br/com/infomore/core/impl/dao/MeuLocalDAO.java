package br.com.infomore.core.impl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.MeuLocal;
import br.com.infomore.dominio.Ponto;

public class MeuLocalDAO extends AbstractDAO<Integer, MeuLocal> {

	public MeuLocalDAO() {
		super(MeuLocal.class);
	}

	@Override
	public List<MeuLocal> listar(EntidadeDominio entidade) {
		return listarLocaisUsuario( (MeuLocal) entidade);
	}

	public List<MeuLocal> listarLocaisUsuario(MeuLocal meuLocal) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query query = em.createQuery(
				"SELECT T FROM " + (MeuLocal.class.getSimpleName() + " T " + "WHERE id_usuario = :id_usuario"));
		query.setParameter("id_usuario", meuLocal.getUsuario().getId());
		return (List<MeuLocal>) query.getResultList();
	}

}
