package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EmprestimoDAO;
import br.com.fiap.entity.Emprestimo;
import br.com.fiap.entity.EmprestimoPK;

public class EmprestimoDAOImpl 
				extends GenericDAOImpl<Emprestimo,EmprestimoPK>
										implements EmprestimoDAO{

	public EmprestimoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public long contarPorUsuario(int codigoUsuario) {
		return em.createQuery("select count(e) from Emprestimo e "
				+ "where e.usuario.codigo = :c", Long.class)
				.setParameter("c", codigoUsuario)
				.getSingleResult();
	}

}
