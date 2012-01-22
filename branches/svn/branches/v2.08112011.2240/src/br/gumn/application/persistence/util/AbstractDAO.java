package br.gumn.application.persistence.util;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

/**
 * Classe abstrata respons�vel por fornecer encapsulamento no acesso aos dados.
 * 
 * @author Gert Uch�a M�ller Neto
 * @param <T> Classe Persistente
 * @version v1.23092011.1342
 */
public abstract class AbstractDAO<T> {
	private Class<T> persistentClass;

	/**
	 * M�todo respons�vel pela instancia��o e extra��o da classe persistente.
	 */
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * M�todo respons�vel pela persist�ncia de uma inst�ncia da classe persistente.
	 * 
	 * @param t T
	 * @return Boolean
	 * @throws EntityExistsException
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 * @throws PersistenceException
	 */
	public boolean persist(T t) throws EntityExistsException, IllegalArgumentException, TransactionRequiredException, PersistenceException {
		EntityManager em = PersistenceFactory.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			return true;
		} finally {
			em.getTransaction().rollback();
			em.close();
		}
	}

	/**
	 * M�todo respons�vel pela atualiza��o de uma inst�ncia da classe persistente.
	 * 
	 * @param t T
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean merge(T t) throws IllegalArgumentException, TransactionRequiredException {
		EntityManager em = PersistenceFactory.createEntityManager();

		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
			return true;
		} finally {
			em.getTransaction().rollback();
			em.close();
		}
	}

	/**
	 * M�todo respons�vel pela remo��o de uma inst�ncia da classe persistente.
	 * 
	 * @param t T
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean remove(T t) throws IllegalArgumentException, TransactionRequiredException {
		EntityManager em = PersistenceFactory.createEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
			return true;
		} finally {
			em.getTransaction().rollback();
			em.close();
		}
	}

	/**
	 * M�todo respons�vel pela busca de uma inst�ncia da classe persistente pela chave-prim�ria.
	 * 
	 * @param pk Integer
	 * @return T
	 * @throws IllegalArgumentException
	 */
	public T find(int pk) throws IllegalArgumentException {
		EntityManager em = PersistenceFactory.createEntityManager();

		try {
			return em.find(this.persistentClass, pk);
		} finally {
			em.close();
		}
	}

	/**
	 * M�todo respons�vel pela busca de uma inst�ncia da classe persistente pela chave-prim�ria.
	 * 
	 * @param pk String
	 * @return T
	 * @throws IllegalArgumentException
	 */
	public T find(String pk) throws IllegalArgumentException {
		EntityManager em = PersistenceFactory.createEntityManager();

		try {
			return em.find(this.persistentClass, pk);
		} finally {
			em.close();
		}
	}

	/**
	 * M�todo respons�vel pela listagem de inst�ncias da classe persistente.
	 * 
	 * @return List<T>
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public Set<T> list() throws IllegalArgumentException {
		EntityManager em = PersistenceFactory.createEntityManager();
		
		try {
			return new HashSet<T>(em.createQuery("from " + persistentClass.getSimpleName()).getResultList());
		} finally {
			em.close();
		}
	}
}
