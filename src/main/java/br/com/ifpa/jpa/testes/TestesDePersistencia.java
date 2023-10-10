package br.com.ifpa.jpa.testes;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.ifpa.jpa.modelo.Aluno;
import br.com.ifpa.jpa.modelo.Emprestimo;
import br.com.ifpa.jpa.modelo.Publicacao;
import br.com.ifpa.jpa.util.EntityManagerFactoryUtil;

public class TestesDePersistencia {

	public static void main(String[] args) {
		popularBancoDeDados();
	}

	private static void popularBancoDeDados() {
		EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();

			Aluno aluno = new Aluno(20192292, "Mayla");
			entityManager.persist(aluno);

			Publicacao publicacao = new Publicacao(1, "Java", 2023, "Fulano", "Tecnico");
			entityManager.persist(publicacao);

			Date dataAtual = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dataAtual);
			calendar.add(Calendar.DAY_OF_MONTH, 10);
			Date dataComDezDias = calendar.getTime();

			Emprestimo emprestimo = new Emprestimo(dataAtual, dataComDezDias, aluno, publicacao);
			entityManager.persist(emprestimo);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}

}
