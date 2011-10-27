package br.gumn.persistence.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceFactory {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("reman");
	private static EntityManager em;

	public static EntityManager createEntityManager() {
		if (em == null) {
			return em = emf.createEntityManager();
		} else if (!em.isOpen()) {
			return em = emf.createEntityManager();
		} else {
			return em;
		}
	}

	public static boolean closeEntityManager() {
		try {
			em.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
