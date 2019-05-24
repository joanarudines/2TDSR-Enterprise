package br.com.fiap.teste;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EmprestimoDAO;
import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.impl.EmprestimoDAOImpl;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Editora;
import br.com.fiap.entity.Emprestimo;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Livro;
import br.com.fiap.entity.Usuario;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Teste {

	private static EmprestimoDAO eDao;
	private static LivroDAO lDao;
	
	@BeforeAll
	public static void inicializar() {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		eDao = new EmprestimoDAOImpl(em);
		lDao = new LivroDAOImpl(em);
	}
	
	@Test
	void contarTest() {
		long qtd = eDao.contarPorUsuario(1);
		assertEquals(1, qtd);
	}
	
	@Test
	void buscaTest() {
		List<Livro> lista = lDao.buscarPorNomeEditora("Ab");
		assertEquals(1, lista.size());
	}
	
	@Test
	void test() {
		Editora editora = new Editora("Abril");
		Livro livro = new Livro("1", "Java", Calendar.getInstance(), 
				Genero.AVENTURA, editora);
		Usuario usuario = new Usuario("Maria", null);
		Emprestimo emprestimo = new Emprestimo(Calendar.getInstance(),
				livro, usuario, 21);
		
		try {
			eDao.cadastrar(emprestimo);
			eDao.commit();
		}catch(Exception e) {
			fail("Erro..");
		}
	}

}




