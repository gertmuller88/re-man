package br.gumn.persistence;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.Department;
import br.gumn.bean.University;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class UniversityDAO extends GenericHibernateDAO<University> {
	public University selectById(int id) {
		Session session = GenericHibernateSessionFactory.openSession();
		return (University) session.load(University.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<University> selectByName(String name) {
		Session session = GenericHibernateSessionFactory.openSession();
		return session.createCriteria(University.class)
				.add(Restrictions.like("name", "%" + name + "%"))
				.addOrder(Order.asc("name")).list();
	}

	@SuppressWarnings("unchecked")
	public List<University> selectByAcronym(String acronym) {
		Session session = GenericHibernateSessionFactory.openSession();
		return session.createCriteria(University.class)
				.add(Restrictions.like("acronym", "%" + acronym + "%"))
				.addOrder(Order.asc("acronym")).list();
	}

	@SuppressWarnings("unchecked")
	public List<University> selectByDepartment(Department department) {
		Session session = GenericHibernateSessionFactory.openSession();
		List<Department> departments = session.createCriteria(Department.class)
				.add(Restrictions.or(Restrictions.or(Restrictions.eq("id", department.getId()), Restrictions.like("name", department.getName())), Restrictions.like("acronym", department.getAcronym())))
				.addOrder(Order.asc("id")).list();
		List<University> universities = new ArrayList<University>();
		for (int i = 0; i < departments.size(); i++) {
			universities.add(departments.get(i).getUniversity());
		}
		return universities;
	}
}
