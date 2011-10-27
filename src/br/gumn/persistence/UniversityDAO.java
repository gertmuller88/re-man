package br.gumn.persistence;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.University;
import br.gumn.persistence.util.AbstractDAO;
import br.gumn.persistence.util.HibernateSessionFactory;

public class UniversityDAO extends AbstractDAO<University> {
	public University selectById(int id) {
		try {
			return (University) HibernateSessionFactory.openSession().load(
					University.class, id);
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List<University> selectByAcronym(String acronym) {
		try {
			return HibernateSessionFactory.openSession()
					.createCriteria(University.class)
					.add(Restrictions.like("acronym", "%" + acronym + "%"))
					.addOrder(Order.asc("acronym")).list();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List<University> selectByName(String name) {
		try {
			return HibernateSessionFactory.openSession()
					.createCriteria(University.class)
					.add(Restrictions.like("name", "%" + name + "%"))
					.addOrder(Order.asc("name")).list();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	public University selectByDepartment(int idDepartment) {
		return new DepartmentDAO().selectById(idDepartment).getUniversity();
	}
}
