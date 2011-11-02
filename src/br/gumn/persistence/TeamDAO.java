package br.gumn.persistence;

import java.util.List;
import br.gumn.bean.Team;
import br.gumn.persistence.util.AbstractDAO;

/**
 * Classe responsável por fornecer encapsulamento no acesso aos dados da
 * entidade Grupo/Time de Pesquisa.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public class TeamDAO extends AbstractDAO<Team> {
	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Grupo/Time de Pesquisa relacionadas a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return List<Team>
	 */
	public List<Team> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getTeams();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Grupo/Time de Pesquisa relacionadas a determinado Projeto de Pesquisa.
	 * 
	 * @param idProject Integer
	 * @return List<Team>
	 */
	public List<Team> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getTeams();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Grupo/Time de Pesquisa relacionadas a determinada Publicação.
	 * 
	 * @param idPublication Integer
	 * @return List<Team>
	 */
	public List<Team> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getTeams();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Grupo/Time de Pesquisa relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return List<Team>
	 */
	public List<Team> selectByMember(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getTeams();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Grupo/Time de Pesquisa relacionadas a determinada Linha de Pesquisa.
	 * 
	 * @param idResearchLine Integer
	 * @return List<Team>
	 */
	public List<Team> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().find(idResearchLine).getTeams();
	}
}
