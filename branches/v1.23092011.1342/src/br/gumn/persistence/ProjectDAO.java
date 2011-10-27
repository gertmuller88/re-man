package br.gumn.persistence;

import java.util.List;
import br.gumn.bean.Project;
import br.gumn.persistence.util.AbstractDAO;

public class ProjectDAO extends AbstractDAO<Project> {
	public List<Project> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getProjects();
	}

	public List<Project> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getProjects();
	}

	public List<Project> selectByMember(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getProjects();
	}

	public List<Project> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().find(idResearchLine).getProjects();
	}

	public List<Project> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getProjects();
	}
}
