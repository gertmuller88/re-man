package br.gumn.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDAO<T> {
	public boolean insert(T t) {
		Session session = GenericSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(t);
		
		try {
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}
	
	public boolean update(T t) {
		Session session = GenericSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		
		try {
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}
	
	public boolean delete(T t) {
		Session session = GenericSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(t);
		
		try {
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}
	
	public T load(T t) {
		return t;
	}
}
