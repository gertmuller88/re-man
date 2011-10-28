package br.gumn.persistence.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe responsável por fornecer a referência de um EntityManager.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 * @see EntityManager EntityManagerFactory
 */
public class PersistenceFactory {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("reman");
	private static EntityManager em;

	/**
	 * Método estático responsável por fornecer uma referência à instância
	 * privada de EntityManager.
	 * 
	 * @return EntityManager
	 */
	public static EntityManager createEntityManager() {
		if (em == null) {
			return em = emf.createEntityManager();
		} else if (!em.isOpen()) {
			return em = emf.createEntityManager();
		} else {
			return em;
		}
	}

	/**
	 * Método estático responsável por fechar a instância privada de
	 * EntityManager.
	 * 
	 * @return Boolean
	 */
	public static boolean closeEntityManager() {
		try {
			em.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
