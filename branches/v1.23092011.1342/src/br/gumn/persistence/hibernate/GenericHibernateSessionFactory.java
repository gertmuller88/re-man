package br.gumn.persistence.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GenericHibernateSessionFactory {
	private static Session session;

	public static Session openSession() {
		Configuration configuration = new Configuration();
		configuration
				.configure("/br/gumn/persistence/hibernate/hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		if (session == null) {
			return session = sf.openSession();
		} else {
			if (session.isOpen())
				return session;
			else
				return session = sf.openSession();
		}
	}
}
