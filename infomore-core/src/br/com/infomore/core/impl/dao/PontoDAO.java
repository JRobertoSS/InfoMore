package br.com.infomore.core.impl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Ponto;

public class PontoDAO extends AbstractDAO<Long, Ponto> {

    public PontoDAO() {
	super(Ponto.class);
    }

    @Override
    public List<Ponto> listar(EntidadeDominio entidade) {
	EntityManager em = entityManagerFactory.createEntityManager();
	Query query = em.createQuery("SELECT T FROM " + (Ponto.class.getSimpleName() + " T"));
	return (List<Ponto>) query.getResultList();
    }

}
