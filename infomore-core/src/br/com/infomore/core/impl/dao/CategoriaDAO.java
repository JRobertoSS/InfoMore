package br.com.infomore.core.impl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.infomore.dominio.Categoria;
import br.com.infomore.dominio.EntidadeDominio;

public class CategoriaDAO extends AbstractDAO<Integer, Categoria> {

    public CategoriaDAO() {
	super(Categoria.class);
    }

    @Override
    public List<Categoria> listar(EntidadeDominio entidade) {
	EntityManager em = entityManagerFactory.createEntityManager();
	Query query = em.createQuery("SELECT T FROM " + (Categoria.class.getSimpleName() + " T"));
	return (List<Categoria>) query.getResultList();
    }

}
