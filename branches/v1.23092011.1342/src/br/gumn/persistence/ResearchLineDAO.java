package br.gumn.persistence;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.ResearchLine;
import br.gumn.persistence.util.AbstractDAO;
import br.gumn.persistence.util.HibernateSessionFactory;

public class ResearchLineDAO extends AbstractDAO<ResearchLine> {
	public ResearchLine selectById(int id) {
		try {
			return (ResearchLine) HibernateSessionFactory.openSession().load(
					ResearchLine.class, id);
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ResearchLine> selectByTitle(String title) {
		try {
			return HibernateSessionFactory.openSession()
					.createCriteria(ResearchLine.class)
					.add(Restrictions.like("title", "%" + title + "%"))
					.addOrder(Order.asc("title")).list();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	public List<ResearchLine> selectByProject(int idProject) {
		return new ProjectDAO().selectById(idProject).getResearchLines();
	}

	public List<ResearchLine> selectByPublication(int idPublication) {
		return new PublicationDAO().selectById(idPublication)
				.getResearchLines();
	}

	public List<ResearchLine> selectByResearcher(String cpfResearcher) {
		return new ResearcherDAO().selectByCpf(cpfResearcher)
				.getResearchLines();
	}

	public List<ResearchLine> selectByTeam(int idTeam) {
		return new TeamDAO().selectById(idTeam).getResearchLines();
	}
}
