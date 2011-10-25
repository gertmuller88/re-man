package br.gumn.persistence;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.Project;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class ProjectDAO extends GenericHibernateDAO<Project> {
	public Project selectById(int id) {
		return (Project) GenericHibernateSessionFactory.openSession().load(
				Project.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Project> selectByName(String name) {
		return GenericHibernateSessionFactory.openSession()
				.createCriteria(Project.class)
				.add(Restrictions.like("name", "%" + name + "%"))
				.addOrder(Order.asc("name")).list();
	}

	public List<Project> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().selectById(idDepartment).getProjects();
	}

	public List<Project> selectByPublication(int idPublication) {
		return new PublicationDAO().selectById(idPublication).getProjects();
	}

	public List<Project> selectByMember(String cpfResearcher) {
		return new ResearcherDAO().selectById(cpfResearcher).getProjects();
	}
	
	public List<Project> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().selectById(idResearchLine).getProjects();
	}
	
	public List<Project> selectByTeam(int idTeam) {
		return new TeamDAO().selectById(idTeam).getProjects();
	}
}
