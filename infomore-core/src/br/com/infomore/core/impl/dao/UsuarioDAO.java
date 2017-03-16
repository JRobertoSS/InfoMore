package br.com.infomore.core.impl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.Usuario;

public class UsuarioDAO extends AbstractDAO<Integer, Usuario> {

    public UsuarioDAO() {
	super(Usuario.class);
    }

    public Usuario consultarPorEmail(String email) {
	EntityManager em = entityManagerFactory.createEntityManager();

	Query query = em.createQuery("from Usuario where email like :email");
	query.setParameter("email", email);
	try {
	    return (Usuario) query.getSingleResult();
	} catch (NoResultException nre) {
	    return null;
	}
    }

    @Override
    public Usuario consultar(Usuario usuario, Integer chave) {
	if (chave == null)
	    return consultarPorEmail(usuario.getEmail());
	return super.consultar(usuario, chave);
    }

    @Override
    public List<Usuario> listar(EntidadeDominio entidade) {
	EntityManager em = entityManagerFactory.createEntityManager();
	Query query = em.createQuery("SELECT T FROM " + (Usuario.class.getSimpleName() + " T"));
	return (List<Usuario>) query.getResultList();
    }

}
