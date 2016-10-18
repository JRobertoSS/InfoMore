package br.com.infomore.core.impl.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.infomore.dominio.Usuario;

public class UsuarioDAO extends AbstractDAO<Long, Usuario> {

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
    public Usuario consultar(Usuario usuario, Long chave) {
	// TODO Auto-generated method stub
	return consultarPorEmail(usuario.getEmail());
    }

}
