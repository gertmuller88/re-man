package br.gumn.application.persistence;

import br.gumn.application.bean.University;
import br.gumn.application.persistence.util.AbstractDAO;

/**
 * Classe respons�vel por fornecer encapsulamento no acesso aos dados da
 * entidade Universidade.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public class UniversityDAO extends AbstractDAO<University> {
	/**
	 * M�todo respons�vel pela busca de uma inst�ncia da entidade
	 * Universidade relacionada a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return University
	 */
	public University selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getUniversity();
	}
}
