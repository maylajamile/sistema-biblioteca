package br.com.ifpa.jpa.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer matricula;
	private String nome;
	@OneToMany(mappedBy = "aluno")
	private List<Emprestimo> emprestimos;
	
	public Aluno(Integer matricula, String nome) {
		this.setId(id);
		this.setMatricula(matricula);
		this.setNome(nome);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getMatricula() {
		return matricula;
	}
	
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
}
