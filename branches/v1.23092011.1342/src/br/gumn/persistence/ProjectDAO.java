package br.gumn.persistence;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.Project;
import br.gumn.persistence.util.AbstractDAO;
import br.gumn.persistence.util.HibernateSessionFactory;

public class ProjectDAO extends AbstractDAO<Project> {
	public Project selectById(int id) {
		try {
			return (Project) HibernateSessionFactory.openSession().load(
					Project.class, id);
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Project> selectByName(String name) {
		try {
			return HibernateSessionFactory.openSession()
					.createCriteria(Project.class)
					.add(Restrictions.like("name", "%" + name + "%"))
					.addOrder(Order.asc("name")).list();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	public List<Project> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().selectById(idDepartment).getProjects();
	}

	public List<Project> selectByPublication(int idPublication) {
		return new PublicationDAO().selectById(idPublication).getProjects();
	}

	public List<Project> selectByMember(String cpfResearcher) {
		return new ResearcherDAO().selectByCpf(cpfResearcher).getProjects();
	}

	public List<Project> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().selectById(idResearchLine).getProjects();
	}

	public List<Project> selectByTeam(int idTeam) {
		return new TeamDAO().selectById(idTeam).getProjects();
	}
}