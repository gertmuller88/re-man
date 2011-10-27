package br.gumn.persistence;

import java.util.List;
import br.gumn.bean.Department;
import br.gumn.persistence.util.AbstractDAO;

public class DepartmentDAO extends AbstractDAO<Department> {
	public List<Department> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getDepartments();
	}

	public List<Department> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getDepartments();
	}

	public List<Department> selectByMember(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getDepartments();
	}

	public List<Department> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getDepartments();
	}

	public List<Department> selectByUniversity(int idUniversity) {
		return new UniversityDAO().find(idUniversity).getDepartments();
	}
}
