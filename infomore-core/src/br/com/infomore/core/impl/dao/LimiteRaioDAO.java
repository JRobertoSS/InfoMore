package br.com.infomore.core.impl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.LimiteRaio;
import br.com.infomore.dominio.Ponto;

public class LimiteRaioDAO extends AbstractDAO<Integer, Ponto> {

    public LimiteRaioDAO() {
	super(Ponto.class);
    }

    @Override
    public List<Ponto> listar(EntidadeDominio entidade) {
	LimiteRaio limiteRaio = (LimiteRaio) entidade;
	EntityManager em = entityManagerFactory.createEntityManager();
	Query query = em.createQuery("SELECT T FROM " + Ponto.class.getSimpleName() + " T WHERE latitude > "
		+ limiteRaio.getPontoSW().getLatitude() + " AND longitude > " + limiteRaio.getPontoSW().getLongitude()
		+ " AND latitude < " + limiteRaio.getPontoNE().getLatitude() + " AND longitude < "
		+ limiteRaio.getPontoNE().getLongitude());
	return (List<Ponto>) query.getResultList();
    }

}
