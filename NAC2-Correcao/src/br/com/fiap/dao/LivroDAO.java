package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Livro;

public interface LivroDAO extends GenericDAO<Livro, String>{

	List<Livro> buscarPorNomeEditora(String editora);
	
}