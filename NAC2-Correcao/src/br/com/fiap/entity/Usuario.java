package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_NAC_USUARIO")
@SequenceGenerator(name = "usuario", sequenceName = "SEQ_NAC_USUARIO", allocationSize = 1)
public class Usuario {

	@Id
	@Column(name = "cd_usuario")
	@GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nm_usuario", nullable = false, length = 50)
	private String nome;

	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@OneToMany(mappedBy="usuario")
	private List<Emprestimo> emprestimos;
	
	public Usuario(String nome, byte[] foto) {
		super();
		this.nome = nome;
		this.foto = foto;
	}

	public Usuario() {
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

}
