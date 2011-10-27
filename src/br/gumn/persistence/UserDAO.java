package br.gumn.persistence;

import br.gumn.bean.User;
import br.gumn.persistence.util.AbstractDAO;
import br.gumn.persistence.util.HibernateSessionFactory;

public class UserDAO extends AbstractDAO<User> {
	public User selectByLogin(String login) {
		try {
			return (User) HibernateSessionFactory.openSession().load(
					User.class, login);
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	public User selectByResearcher(String cpfResearcher) {
		return new ResearcherDAO().selectByCpf(cpfResearcher).getUser();
	}
}
