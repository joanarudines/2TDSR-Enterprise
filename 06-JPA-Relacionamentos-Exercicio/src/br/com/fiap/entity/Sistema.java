package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_SISTEMA")
@SequenceGenerator(name="sistema",sequenceName="SEQ_TAB_SISTEMA",allocationSize=1)
public class Sistema {

	@Id	
	@Column(name="cod_sistema")
	@GeneratedValue(generator="sistema",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nom_sistema")
	private String nome;
	
	@OneToMany(mappedBy="sistema")
	private List<CasoTeste> casos;

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

	public List<CasoTeste> getCasos() {
		return casos;
	}

	public void setCasos(List<CasoTeste> casos) {
		this.casos = casos;
	}
	
}