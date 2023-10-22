package br.com.ifpa.jpa.util;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("biblioteca");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

	public static Date calcularDataDevolucao(Date dataAtual) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataAtual);
		calendar.add(Calendar.DAY_OF_MONTH, 10);
		return calendar.getTime();
	}
}
