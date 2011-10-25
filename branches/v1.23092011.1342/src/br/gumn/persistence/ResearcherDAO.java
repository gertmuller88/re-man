package br.gumn.persistence;

import org.hibernate.Session;
import br.gumn.bean.Researcher;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class ResearcherDAO extends GenericHibernateDAO<Researcher> {
	public Researcher selectById(String id) {
		Session session = GenericHibernateSessionFactory.openSession();
		return (Researcher) session.load(Researcher.class, id);
	}
}
