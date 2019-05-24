package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_NAC_EMPRESTIMO")
@IdClass(EmprestimoPK.class)
public class Emprestimo {

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_emprestimo")
	private Calendar data;
	
	@Id
	@ManyToOne
	@JoinColumn(name="nr_isbn")
	private Livro livro;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cd_usuario")
	private Usuario usuario;
	
	@Column(name="nr_dias")
	private int numeroDias;
	
	public Emprestimo() {
		super();
	}

	public Emprestimo(Calendar data, Livro livro, Usuario usuario, int numeroDias) {
		super();
		this.data = data;
		this.livro = livro;
		this.usuario = usuario;
		this.numeroDias = numeroDias;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(int numeroDias) {
		this.numeroDias = numeroDias;
	}
	
}
