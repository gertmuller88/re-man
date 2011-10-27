package br.gumn.persistence;

import java.util.List;
import br.gumn.bean.Researcher;
import br.gumn.persistence.util.AbstractDAO;

public class ResearcherDAO extends AbstractDAO<Researcher> {
	public List<Researcher> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getMembers();
	}

	public List<Researcher> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getMembers();
	}

	public List<Researcher> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getAuthors();
	}

	public List<Researcher> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().find(idResearchLine).getResearchers();
	}

	public List<Researcher> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getMembers();
	}

	public Researcher selectByUser(String loginUser) {
		return new UserDAO().find(loginUser).getResearcher();
	}
}
