package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Livro;

public interface LivroDAO extends GenericDAO<Livro, Integer>{

	List<Livro> buscarPorTitulo(String titulo);
	
	long contarPorEditora(int editora);
	
}