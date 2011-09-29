package br.gumn.persistence;

import org.hibernate.Session;
import br.gumn.bean.ResearchLine;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class ResearchLineDAO extends GenericHibernateDAO<ResearchLine> {
	public ResearchLine selectById(int id) {
		Session session = GenericHibernateSessionFactory.openSession();
		return (ResearchLine) session.load(ResearchLine.class, id);
	}
}
