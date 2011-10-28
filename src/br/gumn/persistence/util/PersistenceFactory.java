package br.gumn.persistence.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe respons�vel por fornecer a refer�ncia de um EntityManager.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 * @see EntityManager EntityManagerFactory
 */
public class PersistenceFactory {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("reman");
	private static EntityManager em;

	/**
	 * M�todo est�tico respons�vel por fornecer uma refer�ncia � inst�ncia
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
	 * M�todo est�tico respons�vel por fechar a inst�ncia privada de
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
