package br.gumn.persistence;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.Department;
import br.gumn.bean.Project;
import br.gumn.bean.Researcher;
import br.gumn.bean.Team;
import br.gumn.bean.University;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class DepartmentDAO extends GenericHibernateDAO<Department> {
	public Department selectById(int id) {
		Session session = GenericHibernateSessionFactory.openSession();
		return (Department) session.load(University.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Department> selectByAcronym(String acronym) {
		Session session = GenericHibernateSessionFactory.openSession();
		return session.createCriteria(Department.class)
				.add(Restrictions.like("acronym", "%" + acronym + "%"))
				.addOrder(Order.asc("acronym")).list();
	}

	@SuppressWarnings("unchecked")
	public List<Department> selectByName(String name) {
		Session session = GenericHibernateSessionFactory.openSession();
		return session.createCriteria(Department.class)
				.add(Restrictions.like("name", "%" + name + "%"))
				.addOrder(Order.asc("name")).list();
	}

	public List<Department> selectByUniversity(int idUniversity) {
		UniversityDAO universityDAO = new UniversityDAO();
		University university = universityDAO.selectById(idUniversity);
		return university.getDepartments();
	}

	public List<Department> selectByTeam(int idTeam) {
		TeamDAO teamDAO = new TeamDAO();
		Team team = teamDAO.selectById(idTeam);
		return team.getDepartments();
	}

	public List<Department> selectByProject(int idProject) {
		ProjectDAO projectDAO = new ProjectDAO();
		Project project = projectDAO.selectById(idProject);
		return project.getDepartments();
	}

	public List<Department> selectByResearcher(int idResearcher) {
		ResearcherDAO researcherDAO = new ResearcherDAO();
		Researcher researcher = researcherDAO.selectById(idResearcher);
		return researcher.getDepartments();
	}
}
