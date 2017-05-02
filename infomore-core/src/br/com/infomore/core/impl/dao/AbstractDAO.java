package br.com.infomore.core.impl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.infomore.dominio.EntidadeDominio;

public abstract class AbstractDAO<K, T> {
	protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("InfoMore");

	private Class<T> classeObjeto;

	public AbstractDAO(Class<T> classeObjeto) {
		this.classeObjeto = classeObjeto;
	}

	public void salvar(T objeto) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(objeto);
		em.getTransaction().commit();
	}

	public void alterar(T objeto) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(objeto);
		em.getTransaction().commit();
	}

	public void excluir(T objeto) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Object obj = em.merge(objeto);
		em.remove(obj);
		em.getTransaction().commit();
	}

	public T consultar(T objeto, K chave) {
		EntityManager em = entityManagerFactory.createEntityManager();
		return (T) em.find(classeObjeto, chave);
	}

	public List<T> listar() {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query query = em.createQuery("SELECT T FROM " + (classeObjeto.getSimpleName() + " T"));
		return (List<T>) query.getResultList();
	}

	public abstract List<T> listar(EntidadeDominio entidade);
}
