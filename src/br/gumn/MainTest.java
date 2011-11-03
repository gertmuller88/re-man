package br.gumn;

import br.gumn.bean.Department;
import br.gumn.persistence.DepartmentDAO;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DepartmentDAO d = new DepartmentDAO();
		d.persist(new Department());
	}

}
