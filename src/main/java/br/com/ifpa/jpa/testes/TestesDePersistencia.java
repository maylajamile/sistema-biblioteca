package br.com.ifpa.jpa.testes;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ifpa.jpa.dao.EmprestimoDAO;
import br.com.ifpa.jpa.modelo.Aluno;
import br.com.ifpa.jpa.modelo.Emprestimo;
import br.com.ifpa.jpa.modelo.Publicacao;
import br.com.ifpa.jpa.util.JPAUtil;

public class TestesDePersistencia {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(entityManager);

	    try {
	        popularBancoDeDados(entityManager, emprestimoDAO);
	        System.out.println("--------------------------------------------------------");
	        System.out.println("LISTAGEM ANTES DE MODIFICAÇÕES:");
	        listarResultados(emprestimoDAO);

	        removerInsercoes(entityManager, emprestimoDAO);
	        editarDados(entityManager, emprestimoDAO);

	        System.out.println("--------------------------------------------------------");
	        System.out.println("LISTAGEM DEPOIS DE MODIFICAÇÕES:");
	        listarResultados(emprestimoDAO);
	    } catch (Exception e){
	    	System.err.println("[Sistema Biblioteca] - Ocorreu um problema, verifique se o banco e as tabelas foram criadas corretamente ou se os dados já foram inseridos no banco!");
	    } finally {
	        entityManager.close();
	    }	
	 }

	private static void popularBancoDeDados(EntityManager entityManager, EmprestimoDAO emprestimoDAO) {
		Aluno aluno = entityManager.find(Aluno.class, Long.valueOf(1));
		Aluno aluno2 = entityManager.find(Aluno.class, Long.valueOf(2));
		Aluno aluno3 = entityManager.find(Aluno.class, Long.valueOf(3));

		Publicacao publicacao = entityManager.find(Publicacao.class, Long.valueOf(1));
		Publicacao publicacao2 = entityManager.find(Publicacao.class, Long.valueOf(2));
		Publicacao publicacao3 = entityManager.find(Publicacao.class, Long.valueOf(3));

		Date dataAtual = new Date();
		Date dataDevolucao = JPAUtil.calcularDataDevolucao(dataAtual);

		Emprestimo emprestimo = new Emprestimo(dataAtual, dataDevolucao, aluno, publicacao);
		Emprestimo emprestimo2 = new Emprestimo(dataAtual, dataDevolucao, aluno2, publicacao2);
		Emprestimo emprestimo3 = new Emprestimo(dataAtual, dataDevolucao, aluno3, publicacao3);

		emprestimoDAO.insert(emprestimo);
		emprestimoDAO.insert(emprestimo2);
		emprestimoDAO.insert(emprestimo3);
	}

	private static void listarResultados(EmprestimoDAO emprestimoDAO) {
		List<Emprestimo> emprestimos = emprestimoDAO.findAll();

		for (Emprestimo emprestimo : emprestimos) {
			System.out.println("--------------------------------------------------------");
			System.out.println("ID: " + emprestimo.getId());
			System.out.println("Data de Empréstimo: " + emprestimo.getDataEmprestimo());
			System.out.println("Data de Devolução: " + emprestimo.getDataDevolucao());
			System.out.println("Nome do Aluno: " + emprestimo.getAluno().getNome());
			System.out.println("Código da Publicação: " + emprestimo.getPublicacao().getCodigoPub());
		}
	}

	private static void removerInsercoes(EntityManager entityManager, EmprestimoDAO emprestimoDAO) {
		Emprestimo emprestimo = entityManager.find(Emprestimo.class, Long.valueOf(1));
		emprestimoDAO.delete(emprestimo);
	}

	private static void editarDados(EntityManager entityManager, EmprestimoDAO emprestimoDAO) {
		Aluno aluno = entityManager.find(Aluno.class, Long.valueOf(1));
		Publicacao publicacao = entityManager.find(Publicacao.class, Long.valueOf(1));

		Emprestimo emprestimo = entityManager.find(Emprestimo.class, Long.valueOf(2));
		emprestimo.setAluno(aluno);
		emprestimo.setPublicacao(publicacao);
		emprestimo.setDataDevolucao(new Date());
		emprestimoDAO.update(emprestimo);
	}
}
