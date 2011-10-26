package br.gumn.persistence;

import br.gumn.bean.User;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class UserDAO extends GenericHibernateDAO<User> {
	public User selectByLogin(String login) {
		try {
			return (User) GenericHibernateSessionFactory.openSession().load(
					User.class, login);
		} finally {
			GenericHibernateSessionFactory.closeSession();
		}
	}

	public User selectByResearcher(String cpfResearcher) {
		return new ResearcherDAO().selectByCpf(cpfResearcher).getUser();
	}
}
