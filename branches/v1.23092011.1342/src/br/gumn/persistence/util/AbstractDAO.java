package br.gumn.persistence.util;

import java.lang.reflect.ParameterizedType;
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
	 * M�todo pela instancia��o e extra��o da classe persistente.
	 */
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * M�todo respons�vel pela persist�ncia de uma inst�ncia.
	 * 
	 * @param t T
	 * @return Boolean
	 * @throws EntityExistsException
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 * @throws PersistenceException
	 */
	public boolean persist(T t) throws EntityExistsException,
			IllegalArgumentException, TransactionRequiredException,
			PersistenceException {
		EntityManager em = PersistenceFactory.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			return true;
		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			throw e;
		} catch (IllegalArgumentException e) {
			em.getTransaction().rollback();
			throw e;
		} catch (TransactionRequiredException e) {
			em.getTransaction().rollback();
			throw e;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	/**
	 * M�todo respons�vel pela atualiza��o de uma inst�ncia.
	 * 
	 * @param t T
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean merge(T t) throws IllegalArgumentException,
			TransactionRequiredException {
		EntityManager em = PersistenceFactory.createEntityManager();

		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
			return true;
		} catch (IllegalArgumentException e) {
			em.getTransaction().rollback();
			throw e;
		} catch (TransactionRequiredException e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	/**
	 * M�todo respons�vel pela remo��o de uma inst�ncia.
	 * 
	 * @param t T
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean remove(T t) throws IllegalArgumentException,
			TransactionRequiredException {
		EntityManager em = PersistenceFactory.createEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
			return true;
		} catch (IllegalArgumentException e) {
			em.getTransaction().rollback();
			throw e;
		} catch (TransactionRequiredException e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	/**
	 * M�todo respons�vel pela busca de uma inst�ncia da classe persistente pela
	 * chave-prim�ria.
	 * 
	 * @param pk Integer
	 * @return Boolean
	 * @throws IllegalArgumentException
	 */
	public T find(int pk) throws IllegalArgumentException {
		EntityManager em = PersistenceFactory.createEntityManager();

		try {
			return em.find(this.persistentClass, pk);
		} catch (IllegalArgumentException e) {
			throw e;
		} finally {
			em.close();
		}
	}

	/**
	 * M�todo respons�vel pela busca de uma inst�ncia da classe persistente pela
	 * chave-prim�ria.
	 * 
	 * @param pk String
	 * @return Boolean
	 * @throws IllegalArgumentException
	 */
	public T find(String pk) throws IllegalArgumentException {
		EntityManager em = PersistenceFactory.createEntityManager();

		try {
			return em.find(this.persistentClass, pk);
		} catch (IllegalArgumentException e) {
			throw e;
		} finally {
			em.close();
		}
	}
}
