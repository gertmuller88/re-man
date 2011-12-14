package br.gumn.application.persistence;

import java.util.Set;
import br.gumn.application.bean.Project;
import br.gumn.application.persistence.util.GenericDAO;

/**
 * Classe respons�vel por fornecer encapsulamento no acesso aos dados da entidade Projeto de Pesquisa.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public class ProjectDAO extends GenericDAO<Project> {
	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Projeto de Pesquisa relacionadas a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return Set<Project>
	 * @throws IllegalArgumentException
	 */
	public Set<Project> selectByDepartment(int idDepartment) throws IllegalArgumentException {
		return new DepartmentDAO().find(idDepartment).getProjects();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Projeto de Pesquisa relacionadas a determinada Publica��o.
	 * 
	 * @param idPublication Integer
	 * @return Set<Project>
	 * @throws IllegalArgumentException
	 */
	public Set<Project> selectByPublication(int idPublication) throws IllegalArgumentException {
		return new PublicationDAO().find(idPublication).getProjects();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Projeto de Pesquisa relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return Set<Project>
	 * @throws IllegalArgumentException
	 */
	public Set<Project> selectByMember(String cpfResearcher) throws IllegalArgumentException {
		return new ResearcherDAO().find(cpfResearcher).getProjects();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Projeto de Pesquisa relacionadas a determinada Linha de Pesquisa.
	 * 
	 * @param idResearchLine Integer
	 * @return Set<Project>
	 * @throws IllegalArgumentException
	 */
	public Set<Project> selectByResearchLine(int idResearchLine) throws IllegalArgumentException {
		return new ResearchLineDAO().find(idResearchLine).getProjects();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Projeto de Pesquisa relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return Set<Project>
	 * @throws IllegalArgumentException
	 */
	public Set<Project> selectByTeam(int idTeam) throws IllegalArgumentException {
		return new TeamDAO().find(idTeam).getProjects();
	}
}
