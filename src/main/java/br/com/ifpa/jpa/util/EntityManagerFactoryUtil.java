package br.com.ifpa.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("biblioteca");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
