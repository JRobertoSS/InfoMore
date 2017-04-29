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
	EntityManager em = entityManagerFactory.createEntityManager();
	Query query = em.createQuery("SELECT T FROM " + (MeuLocal.class.getSimpleName() + " T"));
	return (List<MeuLocal>) query.getResultList();
    }

}
