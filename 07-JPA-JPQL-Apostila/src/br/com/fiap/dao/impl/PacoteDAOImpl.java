package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		return em.createQuery("from Pacote p where p.transporte = :D",Pacote.class)
				.setParameter("D", transporte)
				.getResultList();
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		return em.createQuery("from Pacote p where p.dataSaida"
				+ " between :i and :f", Pacote.class)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.getResultList();
	}

	@Override
	public double somarPrecoPorTransporte(Transporte transporte) {
		return em.createQuery("select sum(p.preco) from Pacote "
				+ "p where p.transporte = :t",Double.class)
				.setParameter("t", transporte)
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pacote> buscarPorPrecoMaximo(double preco) {
		return em.createNativeQuery("SELECT * FROM PACOTE "
				+ "WHERE PRECO <= :p",Pacote.class)
				.setParameter("p", preco)
				.getResultList();
	}

}










