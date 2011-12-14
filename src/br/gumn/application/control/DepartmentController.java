package br.gumn.application.control;

import java.util.Set;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import br.gumn.application.bean.Department;
import br.gumn.application.persistence.DepartmentDAO;

/**
 * Classe respons�vel pelo controle da entidade Departamento.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v2.08112011.2240
 */
public class DepartmentController {
	/**
	 * M�todo respons�vel pela persist�ncia de uma inst�ncia da entidade Departamento.
	 * 
	 * @param department Department
	 * @return Boolean
	 * @throws EntityExistsException
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 * @throws PersistenceException
	 */
	public boolean persist(Department department) throws EntityExistsException, IllegalArgumentException, TransactionRequiredException, PersistenceException {
		return new DepartmentDAO().persist(department);
	}

	/**
	 * M�todo respons�vel pela atualiza��o de uma inst�ncia da entidade Departamento.
	 * 
	 * @param department Department
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean merge(Department department) throws IllegalArgumentException, TransactionRequiredException {
		return new DepartmentDAO().merge(department);
	}

	/**
	 * M�todo respons�vel pela remo��o de uma inst�ncia da entidade Departamento.
	 * 
	 * @param department Department
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean remove(Department department) throws IllegalArgumentException, TransactionRequiredException {
		return new DepartmentDAO().remove(department);
	}

	/**
	 * M�todo respons�vel pela busca de uma inst�ncia da entidade Departamento pela chave-prim�ria.
	 * 
	 * @param id Integer
	 * @return T
	 * @throws IllegalArgumentException
	 */
	public Department find(int id) throws IllegalArgumentException {
		return new DepartmentDAO().find(id);
	}

	/**
	 * M�todo respons�vel pela listagem de inst�ncias da entidade Departamento.
	 * 
	 * @return Set<Department>
	 * @throws IllegalArgumentException
	 */
	public Set<Department> list() throws IllegalArgumentException {
		return new DepartmentDAO().list();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Departamento relacionadas a determinado Projeto.
	 * 
	 * @param idProject Integer
	 * @return Set<Department>
	 * @throws IllegalArgumentException
	 */
	public Set<Department> selectByProject(int idProject) throws IllegalArgumentException {
		return new DepartmentDAO().selectByProject(idProject);
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Departamento relacionadas a determinada Publica��o.
	 * 
	 * @param idPublication Integer
	 * @return Set<Department>
	 * @throws IllegalArgumentException
	 */
	public Set<Department> selectByPublication(int idPublication) throws IllegalArgumentException {
		return new DepartmentDAO().selectByPublication(idPublication);
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Departamento relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return Set<Department>
	 * @throws IllegalArgumentException
	 */
	public Set<Department> selectByMember(String cpfResearcher) throws IllegalArgumentException {
		return new DepartmentDAO().selectByMember(cpfResearcher);
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Departamento relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return Set<Department>
	 * @throws IllegalArgumentException
	 */
	public Set<Department> selectByTeam(int idTeam) throws IllegalArgumentException {
		return new DepartmentDAO().selectByTeam(idTeam);
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Departamento relacionadas a determinada Universidade.
	 * 
	 * @param idUnivesity Integer
	 * @return Set<Department>
	 * @throws IllegalArgumentException
	 */
	public Set<Department> selectByUniversity(int idUnivesity) throws IllegalArgumentException {
		return new DepartmentDAO().selectByUniversity(idUnivesity);
	}
}
