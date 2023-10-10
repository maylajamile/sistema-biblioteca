package br.com.ifpa.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.ifpa.jpa.modelo.Emprestimo;

public class EmprestimoDAO {

	private EntityManager entityManager;

	public EmprestimoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Emprestimo findById(Long id) {
		return entityManager.find(Emprestimo.class, id);
	}
	
	public List<Emprestimo> findAll(){
		String jpql = "SELECT e FROM Emprestimo e";
		return entityManager.createQuery(jpql, Emprestimo.class).getResultList();
	}
	
	public void insert(Emprestimo emprestimo) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(emprestimo);
		transaction.commit();
	}

	public void update(Emprestimo emprestimo) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(emprestimo);
		transaction.commit();
	}

	public void delete(Emprestimo emprestimo) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Emprestimo emprestimoDeletado = entityManager.find(Emprestimo.class, emprestimo.getId());
		entityManager.remove(emprestimoDeletado);
		transaction.commit();
	}

	
}
