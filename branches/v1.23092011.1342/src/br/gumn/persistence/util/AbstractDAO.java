package br.gumn.persistence.util;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

public abstract class AbstractDAO<T> {
	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

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
