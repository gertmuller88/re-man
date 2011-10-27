package br.gumn.persistence;

import java.util.List;
import br.gumn.bean.ResearchLine;
import br.gumn.persistence.util.AbstractDAO;

public class ResearchLineDAO extends AbstractDAO<ResearchLine> {
	public List<ResearchLine> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getResearchLines();
	}

	public List<ResearchLine> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getResearchLines();
	}

	public List<ResearchLine> selectByResearcher(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getResearchLines();
	}

	public List<ResearchLine> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getResearchLines();
	}
}
