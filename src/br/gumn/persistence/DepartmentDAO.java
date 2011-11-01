package br.gumn.persistence;

import java.util.List;
import br.gumn.bean.Department;
import br.gumn.persistence.util.AbstractDAO;

/**
 * Classe respons�vel por fornecer encapsulamento no acesso aos dados da
 * entidade Departamento.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public class DepartmentDAO extends AbstractDAO<Department> {
	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Departamento relacionadas a determinado Projeto.
	 * 
	 * @param idProject Integer
	 * @return List<Department>
	 */
	public List<Department> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getDepartments();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Departamento relacionadas a determinada Publica��o.
	 * 
	 * @param idPublication Integer
	 * @return List<Department>
	 */
	public List<Department> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getDepartments();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Departamento relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return List<Department>
	 */
	public List<Department> selectByMember(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getDepartments();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Departamento relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return List<Department>
	 */
	public List<Department> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getDepartments();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Departamento relacionadas a determinada Universidade.
	 * 
	 * @param idUniversity Integer
	 * @return List<Department>
	 */
	public List<Department> selectByUniversity(int idUniversity) {
		return new UniversityDAO().find(idUniversity).getDepartments();
	}
}
