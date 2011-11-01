package br.gumn.persistence;

import java.util.List;
import br.gumn.bean.Project;
import br.gumn.persistence.util.AbstractDAO;

/**
 * Classe responsável por fornecer encapsulamento no acesso aos dados da
 * entidade Projeto de Pesquisa.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public class ProjectDAO extends AbstractDAO<Project> {
	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Projeto de Pesquisa relacionadas a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return List<Project>
	 */
	public List<Project> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getProjects();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Projeto de Pesquisa relacionadas a determinada Publicação.
	 * 
	 * @param idPublication Integer
	 * @return List<Project>
	 */
	public List<Project> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getProjects();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Projeto de Pesquisa relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return List<Project>
	 */
	public List<Project> selectByMember(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getProjects();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Projeto de Pesquisa relacionadas a determinada Linha de Pesquisa.
	 * 
	 * @param idResearchLine Integer
	 * @return List<Project>
	 */
	public List<Project> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().find(idResearchLine).getProjects();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Projeto de Pesquisa relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return List<Project>
	 */
	public List<Project> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getProjects();
	}
}
