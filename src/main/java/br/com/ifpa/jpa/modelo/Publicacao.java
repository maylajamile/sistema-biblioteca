package br.com.ifpa.jpa.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Publicacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer codigoPub;
	private String titulo;
	private Integer ano;
	private String autor;
	private String tipo;
	
	@OneToMany(mappedBy = "publicacao")
	private List<Emprestimo> emprestimos;
	
	public Publicacao(Integer codigoPub, String titulo, Integer ano, String autor, String tipo) {
		this.setId(id);
		this.setCodigoPub(codigoPub);
		this.setTitulo(titulo);
		this.setAno(ano);
		this.setAutor(autor);
		this.setTipo(tipo);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getCodigoPub() {
		return codigoPub;
	}
	
	public void setCodigoPub(Integer codigoPub) {
		this.codigoPub = codigoPub;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Integer getAno() {
		return ano;
	}
	
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
}
