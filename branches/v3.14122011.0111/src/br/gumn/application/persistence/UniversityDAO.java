package br.gumn.application.persistence;

import br.gumn.application.bean.University;
import br.gumn.application.persistence.util.GenericDAO;

/**
 * Classe responsável por fornecer encapsulamento no acesso aos dados da entidade Universidade.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public class UniversityDAO extends GenericDAO<University> {
	/**
	 * Método responsável pela busca de uma instância da entidade Universidade relacionada a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return University
	 * @throws IllegalArgumentException
	 */
	public University selectByDepartment(int idDepartment) throws IllegalArgumentException {
		return new DepartmentDAO().find(idDepartment).getUniversity();
	}
}
