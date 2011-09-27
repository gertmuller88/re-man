package br.gumn;

import java.util.List;
import br.gumn.bean.Department;
import br.gumn.bean.University;
import br.gumn.persistence.UniversityDAO;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department department = new Department();
		department.setName("Centro de Informática");
		department.setAcronym("Poli");
		department.setId(3);
		
		UniversityDAO universityDAO = new UniversityDAO();
		List<University> universities = universityDAO.selectByDepartment(department);
		
		for(int i=0; i<universities.size(); i++) {
			System.out.println(universities.get(i).getId());
			System.out.println(universities.get(i).getAcronym());
			System.out.println(universities.get(i).getName());
		}
	}

}
