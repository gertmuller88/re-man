package br.gumn.persistence;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.ResearchLine;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class ResearchLineDAO extends GenericHibernateDAO<ResearchLine> {
	public ResearchLine selectById(int id) {
		return (ResearchLine) GenericHibernateSessionFactory.openSession()
				.load(ResearchLine.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<ResearchLine> selectByTitle(String title) {
		return GenericHibernateSessionFactory.openSession()
				.createCriteria(ResearchLine.class)
				.add(Restrictions.like("title", "%" + title + "%"))
				.addOrder(Order.asc("title")).list();
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
