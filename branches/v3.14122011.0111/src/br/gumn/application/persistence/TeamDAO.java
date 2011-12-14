package br.gumn.application.persistence;

import java.util.Set;
import br.gumn.application.bean.Team;
import br.gumn.application.persistence.util.GenericDAO;

/**
 * Classe respons�vel por fornecer encapsulamento no acesso aos dados da entidade Grupo/Time de Pesquisa.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public class TeamDAO extends GenericDAO<Team> {
	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Grupo/Time de Pesquisa relacionadas a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return Set<Team>
	 * @throws IllegalArgumentException
	 */
	public Set<Team> selectByDepartment(int idDepartment) throws IllegalArgumentException {
		return new DepartmentDAO().find(idDepartment).getTeams();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Grupo/Time de Pesquisa relacionadas a determinado Projeto de Pesquisa.
	 * 
	 * @param idProject Integer
	 * @return Set<Team>
	 * @throws IllegalArgumentException
	 */
	public Set<Team> selectByProject(int idProject) throws IllegalArgumentException {
		return new ProjectDAO().find(idProject).getTeams();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Grupo/Time de Pesquisa relacionadas a determinada Publica��o.
	 * 
	 * @param idPublication Integer
	 * @return Set<Team>
	 * @throws IllegalArgumentException
	 */
	public Set<Team> selectByPublication(int idPublication) throws IllegalArgumentException {
		return new PublicationDAO().find(idPublication).getTeams();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Grupo/Time de Pesquisa relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return Set<Team>
	 * @throws IllegalArgumentException
	 */
	public Set<Team> selectByMember(String cpfResearcher) throws IllegalArgumentException {
		return new ResearcherDAO().find(cpfResearcher).getTeams();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Grupo/Time de Pesquisa relacionadas a determinada Linha de Pesquisa.
	 * 
	 * @param idResearchLine Integer
	 * @return Set<Team>
	 * @throws IllegalArgumentException
	 */
	public Set<Team> selectByResearchLine(int idResearchLine) throws IllegalArgumentException {
		return new ResearchLineDAO().find(idResearchLine).getTeams();
	}
}
