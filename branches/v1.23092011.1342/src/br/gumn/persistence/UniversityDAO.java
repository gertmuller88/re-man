package br.gumn.persistence;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.University;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class UniversityDAO extends GenericHibernateDAO<University> {
	public University selectById(int id) {
		return (University) GenericHibernateSessionFactory.openSession().load(
				University.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<University> selectByAcronym(String acronym) {
		return GenericHibernateSessionFactory.openSession()
				.createCriteria(University.class)
				.add(Restrictions.like("acronym", "%" + acronym + "%"))
				.addOrder(Order.asc("acronym")).list();
	}

	@SuppressWarnings("unchecked")
	public List<University> selectByName(String name) {
		return GenericHibernateSessionFactory.openSession()
				.createCriteria(University.class)
				.add(Restrictions.like("name", "%" + name + "%"))
				.addOrder(Order.asc("name")).list();
	}

	public University selectByDepartment(int idDepartment) {
		return new DepartmentDAO().selectById(idDepartment).getUniversity();
	}
}
