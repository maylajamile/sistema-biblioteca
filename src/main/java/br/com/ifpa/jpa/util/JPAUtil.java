package br.com.ifpa.jpa.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("biblioteca");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

	public static void executeSqlScript(String scriptPath) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/biblioteca");
		dataSource.setUsername("sa");
		dataSource.setPassword("");

		try {
			QueryRunner queryRunner = new QueryRunner(dataSource);
			queryRunner.update(new String(Files.readAllBytes(Paths.get(scriptPath))));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Date calcularDataDevolucao(Date dataAtual) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataAtual);
		calendar.add(Calendar.DAY_OF_MONTH, 10);
		return calendar.getTime();
	}
}
