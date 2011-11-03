package br.gumn;

import java.util.List;

import br.gumn.bean.Department;
import br.gumn.persistence.DepartmentDAO;

/**
 * @author gert.muller
 *
 */
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DepartmentDAO dao = new DepartmentDAO();
		List<Department> lista = dao.list();
		
		for(Department d : lista) {
			System.out.println(d.getId());
		}
	}

}
