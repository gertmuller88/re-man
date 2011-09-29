package br.gumn.persistence;

import org.hibernate.Session;
import br.gumn.bean.Team;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class TeamDAO extends GenericHibernateDAO<Team> {
	public Team selectById(int id) {
		Session session = GenericHibernateSessionFactory.openSession();
		return (Team) session.load(Session.class, id);
	}
}
