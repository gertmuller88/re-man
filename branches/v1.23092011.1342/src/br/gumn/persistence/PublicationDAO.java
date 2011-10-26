package br.gumn.persistence;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.gumn.bean.Publication;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class PublicationDAO extends GenericHibernateDAO<Publication> {
	public Publication selectById(int id) {
		return (Publication) GenericHibernateSessionFactory.openSession().load(
				Publication.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Publication> selectByTitle(String title) {
		return GenericHibernateSessionFactory.openSession()
				.createCriteria(Publication.class)
				.add(Restrictions.like("title", "%" + title + "%"))
				.addOrder(Order.asc("title")).list();
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
