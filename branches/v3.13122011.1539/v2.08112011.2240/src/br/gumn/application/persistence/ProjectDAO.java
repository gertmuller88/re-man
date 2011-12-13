package br.gumn.application.persistence;

import java.util.Set;
import br.gumn.application.bean.Project;
import br.gumn.application.persistence.util.AbstractDAO;

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
	 * @return Set<Project>
	 */
	public Set<Project> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getProjects();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Projeto de Pesquisa relacionadas a determinada Publicação.
	 * 
	 * @param idPublication Integer
	 * @return Set<Project>
	 */
	public Set<Project> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getProjects();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Projeto de Pesquisa relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return Set<Project>
	 */
	public Set<Project> selectByMember(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getProjects();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Projeto de Pesquisa relacionadas a determinada Linha de Pesquisa.
	 * 
	 * @param idResearchLine Integer
	 * @return Set<Project>
	 */
	public Set<Project> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().find(idResearchLine).getProjects();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Projeto de Pesquisa relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return Set<Project>
	 */
	public Set<Project> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getProjects();
	}
}
