package br.com.fiap.dao.impl;

import br.com.fiap.entity.Livro;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.fiap.dao.LivroDAO;

public class LivroDAOImpl extends GenericDAOImpl<Livro, Integer>
												implements LivroDAO {

	public LivroDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Livro> buscarPorTitulo(String titulo) {
		return em.createQuery("from Livro where titulo like :t",
				Livro.class).setParameter("t", "%" +titulo + "%")
				.getResultList();
	}

	@Override
	public long contarPorEditora(int editora) {
		return em.createQuery("select count(l) from Livro l where "
				+ "l.editora.codigo = :c", Long.class)
				.setParameter("c", editora)
				.getSingleResult();
	}

}





