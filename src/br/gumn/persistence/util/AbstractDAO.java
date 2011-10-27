package br.gumn.persistence.util;

import org.hibernate.Session;

public abstract class AbstractDAO<T> {
	public boolean insert(T t) {
		Session session = GenericHibernateSessionFactory.openSession();
		session.beginTransaction();
		session.save(t);

		try {
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean update(T t) {
		Session session = GenericHibernateSessionFactory.openSession();
		session.beginTransaction();
		session.update(t);

		try {
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean insertOrUpdate(T t) {
		Session session = GenericHibernateSessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(t);

		try {
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean delete(T t) {
		Session session = GenericHibernateSessionFactory.openSession();
		session.beginTransaction();
		session.delete(t);

		try {
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}
}
