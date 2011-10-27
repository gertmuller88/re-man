package br.gumn.persistence;

import br.gumn.bean.University;
import br.gumn.persistence.util.AbstractDAO;

public class UniversityDAO extends AbstractDAO<University> {
	public University selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getUniversity();
	}
}
