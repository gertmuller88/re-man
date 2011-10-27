package br.gumn.persistence;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.Department;
import br.gumn.persistence.util.AbstractDAO;
import br.gumn.persistence.util.HibernateSessionFactory;

public class DepartmentDAO extends AbstractDAO<Department> {
	public Department selectById(int id) {
		try {
			return (Department) HibernateSessionFactory.openSession().load(
					Department.class, id);
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Department> selectByAcronym(String acronym) {
		try {
			return HibernateSessionFactory.openSession()
					.createCriteria(Department.class)
					.add(Restrictions.like("acronym", "%" + acronym + "%"))
					.addOrder(Order.asc("acronym")).list();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Department> selectByName(String name) {
		try {
			return HibernateSessionFactory.openSession()
					.createCriteria(Department.class)
					.add(Restrictions.like("name", "%" + name + "%"))
					.addOrder(Order.asc("name")).list();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	public List<Department> selectByProject(int idProject) {
		return new ProjectDAO().selectById(idProject).getDepartments();
	}

	public List<Department> selectByPublication(int idPublication) {
		return new PublicationDAO().selectById(idPublication).getDepartments();
	}

	public List<Department> selectByMember(String cpfResearcher) {
		return new ResearcherDAO().selectByCpf(cpfResearcher).getDepartments();
	}

	public List<Department> selectByTeam(int idTeam) {
		return new TeamDAO().selectById(idTeam).getDepartments();
	}

	public List<Department> selectByUniversity(int idUniversity) {
		return new UniversityDAO().selectById(idUniversity).getDepartments();
	}
}