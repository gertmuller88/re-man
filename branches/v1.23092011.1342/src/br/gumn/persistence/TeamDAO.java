package br.gumn.persistence;

import java.util.List;
import br.gumn.bean.Team;
import br.gumn.persistence.util.AbstractDAO;

public class TeamDAO extends AbstractDAO<Team> {
	public List<Team> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getTeams();
	}

	public List<Team> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getTeams();
	}

	public List<Team> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getTeams();
	}

	public List<Team> selectByMember(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getTeams();
	}

	public List<Team> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().find(idResearchLine).getTeams();
	}
}
