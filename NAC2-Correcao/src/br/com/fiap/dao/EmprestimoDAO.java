package br.com.fiap.dao;

import br.com.fiap.entity.Emprestimo;
import br.com.fiap.entity.EmprestimoPK;

public interface EmprestimoDAO 
				extends GenericDAO<Emprestimo, EmprestimoPK> {

	long contarPorUsuario(int codigoUsuario);
	
}
