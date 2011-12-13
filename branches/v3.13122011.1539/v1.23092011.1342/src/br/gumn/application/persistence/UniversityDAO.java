package br.gumn.application.persistence;

import br.gumn.application.bean.University;
import br.gumn.application.persistence.util.AbstractDAO;

/**
 * Classe responsável por fornecer encapsulamento no acesso aos dados da
 * entidade Universidade.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public class UniversityDAO extends AbstractDAO<University> {
	/**
	 * Método responsável pela busca de uma instância da entidade
	 * Universidade relacionada a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return University
	 */
	public University selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getUniversity();
	}
}
