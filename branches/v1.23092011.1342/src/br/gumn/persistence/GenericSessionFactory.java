package br.gumn.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GenericSessionFactory {
	public static Session openSession() {
		Configuration configuration = new Configuration();
		configuration.configure("/br/gumn/persistence/hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		return sf.openSession();
	}
}
