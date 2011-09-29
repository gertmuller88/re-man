package br.gumn.persistence;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.User;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class UserDAO extends GenericHibernateDAO<User> {
	@SuppressWarnings("unchecked")
	public List<User> selectByLogin(String login) {
		Session session = GenericHibernateSessionFactory.openSession();
		return session.createCriteria(User.class)
				.add(Restrictions.like("login", login))
				.addOrder(Order.asc("login")).list();
	}
}
