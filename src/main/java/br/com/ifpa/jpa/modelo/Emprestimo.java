package br.com.ifpa.jpa.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date dataDevolução;
	private Date dataEmprestimo;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "publicacao_id")
	private Publicacao publicacao;

	public Emprestimo() {}

	public Emprestimo(Date dataEmprestimo, Date dataDevolução, Aluno aluno, Publicacao publicacao) {
		this.setId(id);
		this.setDataDevolução(dataDevolução);
		this.setDataEmprestimo(dataEmprestimo);
		this.setAluno(aluno);
		this.setPublicacao(publicacao);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataDevolução() {
		return dataDevolução;
	}

	public void setDataDevolução(Date dataDevolução) {
		this.dataDevolução = dataDevolução;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

}
