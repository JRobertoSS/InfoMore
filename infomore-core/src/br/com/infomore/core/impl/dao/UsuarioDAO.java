package br.com.infomore.core.impl.dao;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;

import br.com.infomore.dominio.Usuario;

public class UsuarioDAO extends AbstractDAO<Long, Usuario> {

    public UsuarioDAO() {
	super(Usuario.class);
    }

    public Usuario consultarPorEmail(String email) {
	EntityManager em = entityManagerFactory.createEntityManager();

	Query query = em.createQuery("SELECT * FROM " + Usuario.class.getAnnotation(Table.class).name() + "WHERE "
		+ Usuario.class.getAnnotation(Column.class).name() + " like " + email);

	return (Usuario) query.getResultList();
    }

    @Override
    public Usuario consultar(Usuario usuario, Long chave) {
	// TODO Auto-generated method stub
	return consultarPorEmail(usuario.getEmail());
    }

}
