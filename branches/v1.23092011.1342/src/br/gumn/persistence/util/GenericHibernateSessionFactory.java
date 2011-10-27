package br.gumn.persistence.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GenericHibernateSessionFactory {
	private static Session session;

	public static Session openSession() {
		if (session == null) {
			Configuration configuration = new Configuration();
			configuration
					.configure("/br/gumn/persistence/hibernate/hibernate.cfg.xml");
			SessionFactory sf = configuration.buildSessionFactory();
			return session = sf.openSession();
		} else if (!session.isOpen()) {
			Configuration configuration = new Configuration();
			configuration
					.configure("/br/gumn/persistence/hibernate/hibernate.cfg.xml");
			SessionFactory sf = configuration.buildSessionFactory();
			return session = sf.openSession();
		} else {
			return session;
		}
	}
	
	public static boolean closeSession() {
		session.close();
		return true;
	}
}
