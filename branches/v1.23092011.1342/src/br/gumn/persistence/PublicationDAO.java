package br.gumn.persistence;

import java.util.List;
import br.gumn.bean.Publication;
import br.gumn.persistence.util.AbstractDAO;

public class PublicationDAO extends AbstractDAO<Publication> {
	public List<Publication> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getPublications();
	}

	public List<Publication> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getPublications();
	}

	public List<Publication> selectByAuthor(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getPublications();
	}

	public List<Publication> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().find(idResearchLine).getPublications();
	}

	public List<Publication> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getPublications();
	}
}
