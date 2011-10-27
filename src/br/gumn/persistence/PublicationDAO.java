package br.gumn.persistence;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.Publication;
import br.gumn.persistence.util.AbstractDAO;
import br.gumn.persistence.util.HibernateSessionFactory;

public class PublicationDAO extends AbstractDAO<Publication> {
	public Publication selectById(int id) {
		try {
			return (Publication) HibernateSessionFactory.openSession().load(
					Publication.class, id);
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Publication> selectByTitle(String title) {
		try {
			return HibernateSessionFactory.openSession()
					.createCriteria(Publication.class)
					.add(Restrictions.like("title", "%" + title + "%"))
					.addOrder(Order.asc("title")).list();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	public List<Publication> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().selectById(idDepartment).getPublications();
	}

	public List<Publication> selectByProject(int idProject) {
		return new ProjectDAO().selectById(idProject).getPublications();
	}

	public List<Publication> selectByAuthor(String cpfResearcher) {
		return new ResearcherDAO().selectByCpf(cpfResearcher).getPublications();
	}

	public List<Publication> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().selectById(idResearchLine)
				.getPublications();
	}

	public List<Publication> selectByTeam(int idTeam) {
		return new TeamDAO().selectById(idTeam).getPublications();
	}
}
