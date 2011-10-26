package br.gumn.persistence;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.Researcher;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class ResearcherDAO extends GenericHibernateDAO<Researcher> {
	public Researcher selectByCpf(String id) {
		try {
			return (Researcher) GenericHibernateSessionFactory.openSession()
					.load(Researcher.class, id);
		} finally {
			GenericHibernateSessionFactory.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Researcher> selectByName(String name) {
		try {
			return GenericHibernateSessionFactory.openSession()
					.createCriteria(Researcher.class)
					.add(Restrictions.like("name", "%" + name + "%"))
					.addOrder(Order.asc("name")).list();
		} finally {
			GenericHibernateSessionFactory.closeSession();
		}
	}

	public List<Researcher> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().selectById(idDepartment).getMembers();
	}

	public List<Researcher> selectByProject(int idProject) {
		return new ProjectDAO().selectById(idProject).getMembers();
	}

	public List<Researcher> selectByPublication(int idPublication) {
		return new PublicationDAO().selectById(idPublication).getAuthors();
	}

	public List<Researcher> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().selectById(idResearchLine)
				.getResearchers();
	}

	public List<Researcher> selectByTeam(int idTeam) {
		return new TeamDAO().selectById(idTeam).getMembers();
	}

	public Researcher selectByUser(String loginUser) {
		return new UserDAO().selectByLogin(loginUser).getResearcher();
	}
}
