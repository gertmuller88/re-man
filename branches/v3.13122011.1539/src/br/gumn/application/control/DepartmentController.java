package br.gumn.application.control;

import java.util.Set;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import br.gumn.application.bean.Department;
import br.gumn.application.persistence.DepartmentDAO;

/**
 * Classe responsável pelo controle da entidade Departamento.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v2.08112011.2240
 */
public class DepartmentController {
	/**
	 * Método responsável pela persistência de uma instância da entidade Departamento.
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
	 * Método responsável pela atualização de uma instância da entidade Departamento.
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
	 * Método responsável pela remoção de uma instância da entidade Departamento.
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
	 * Método responsável pela busca de uma instância da entidade Departamento pela chave-primária.
	 * 
	 * @param id Integer
	 * @return T
	 * @throws IllegalArgumentException
	 */
	public Department find(int id) throws IllegalArgumentException {
		return new DepartmentDAO().find(id);
	}

	/**
	 * Método responsável pela listagem de instâncias da entidade Departamento.
	 * 
	 * @return Set<Department>
	 * @throws IllegalArgumentException
	 */
	public Set<Department> list() throws IllegalArgumentException {
		return new DepartmentDAO().list();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade Departamento relacionadas a determinado Projeto.
	 * 
	 * @param idProject Integer
	 * @return Set<Department>
	 * @throws IllegalArgumentException
	 */
	public Set<Department> selectByProject(int idProject) throws IllegalArgumentException {
		return new DepartmentDAO().selectByProject(idProject);
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade Departamento relacionadas a determinada Publicação.
	 * 
	 * @param idPublication Integer
	 * @return Set<Department>
	 * @throws IllegalArgumentException
	 */
	public Set<Department> selectByPublication(int idPublication) throws IllegalArgumentException {
		return new DepartmentDAO().selectByPublication(idPublication);
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade Departamento relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return Set<Department>
	 * @throws IllegalArgumentException
	 */
	public Set<Department> selectByMember(String cpfResearcher) throws IllegalArgumentException {
		return new DepartmentDAO().selectByMember(cpfResearcher);
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade Departamento relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return Set<Department>
	 * @throws IllegalArgumentException
	 */
	public Set<Department> selectByTeam(int idTeam) throws IllegalArgumentException {
		return new DepartmentDAO().selectByTeam(idTeam);
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade Departamento relacionadas a determinada Universidade.
	 * 
	 * @param idUnivesity Integer
	 * @return Set<Department>
	 * @throws IllegalArgumentException
	 */
	public Set<Department> selectByUniversity(int idUnivesity) throws IllegalArgumentException {
		return new DepartmentDAO().selectByUniversity(idUnivesity);
	}
}
