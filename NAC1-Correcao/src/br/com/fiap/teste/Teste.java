package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Editora;
import br.com.fiap.entity.Livro;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Teste {

	private static LivroDAO livroDao;
	
	@BeforeAll
	public static void inicializar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		livroDao = new LivroDAOImpl(em);
	}
	
	@Test
	void buscaTeste() {
		List<Livro> livros = livroDao.buscarPorTitulo("Tes");
		assertEquals(1, livros.size());
	}
	
	@Test
	void contaTeste() {
		long qtd = livroDao.contarPorEditora(1);
		assertEquals(1, qtd);
	}
	
	@Test
	void test() {
		Editora editora = new Editora("Teste");
		Autor autor = new Autor("Thiago", Calendar.getInstance(), 1, "Teste");
		List<Autor> autores = new ArrayList<>();
		autores.add(autor);
		Livro livro = new Livro(1, "Java", null, editora, autores);
		
		try {
			livroDao.cadastrar(livro);
			livroDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Erro..");
		}
	}

}
