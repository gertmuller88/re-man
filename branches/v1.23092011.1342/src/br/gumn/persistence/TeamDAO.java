package br.gumn.persistence;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.Team;
import br.gumn.persistence.util.AbstractDAO;
import br.gumn.persistence.util.HibernateSessionFactory;

public class TeamDAO extends AbstractDAO<Team> {
	public Team selectById(int id) {
		try {
			return (Team) HibernateSessionFactory.openSession().load(
					Team.class, id);
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Team> selectByName(String name) {
		try {
			return HibernateSessionFactory.openSession()
					.createCriteria(Team.class)
					.add(Restrictions.like("name", "%" + name + "%"))
					.addOrder(Order.asc("name")).list();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	public List<Team> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().selectById(idDepartment).getTeams();
	}

	public List<Team> selectByProject(int idProject) {
		return new ProjectDAO().selectById(idProject).getTeams();
	}

	public List<Team> selectByPublication(int idPublication) {
		return new PublicationDAO().selectById(idPublication).getTeams();
	}

	public List<Team> selectByMember(String cpfResearcher) {
		return new ResearcherDAO().selectByCpf(cpfResearcher).getTeams();
	}

	public List<Team> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().selectById(idResearchLine).getTeams();
	}
}