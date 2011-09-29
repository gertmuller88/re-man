package br.gumn.persistence;

import org.hibernate.Session;
import br.gumn.bean.Publication;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class PublicationDAO extends GenericHibernateDAO<Publication> {
	public Publication selectById(int id) {
		Session session = GenericHibernateSessionFactory.openSession();
		return (Publication) session.load(Publication.class, id);
	}
}
