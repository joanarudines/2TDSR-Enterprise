package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_NAC_AUTOR")
@SecondaryTable(name="T_NAC_DADOS_AUTOR")
@SequenceGenerator(name="autor",sequenceName="SEQ_NAC_AUTOR",allocationSize=1)
public class Autor {

	@Id
	@Column(name="cd_autor")
	@GeneratedValue(generator="autor",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_autor", length = 100, nullable = false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Column(name="nr_livros_publicados", table="T_NAC_DADOS_AUTOR")
	private int numeroPublicado;
	
	@Column(name="ds_autor", length=500, table="T_NAC_DADOS_AUTOR")
	private String descricao;
	
	@ManyToMany(mappedBy="autores")
	private List<Livro> livros;
	
	public Autor(String nome, Calendar dataNascimento, int numeroPublicado, String descricao) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.numeroPublicado = numeroPublicado;
		this.descricao = descricao;
	}

	public Autor() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getNumeroPublicado() {
		return numeroPublicado;
	}

	public void setNumeroPublicado(int numeroPublicado) {
		this.numeroPublicado = numeroPublicado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
}





