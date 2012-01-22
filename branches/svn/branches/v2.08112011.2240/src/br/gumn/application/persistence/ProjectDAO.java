package br.gumn.application.persistence;

import java.util.Set;
import br.gumn.application.bean.Project;
import br.gumn.application.persistence.util.AbstractDAO;

/**
 * Classe respons�vel por fornecer encapsulamento no acesso aos dados da
 * entidade Projeto de Pesquisa.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public class ProjectDAO extends AbstractDAO<Project> {
	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Projeto de Pesquisa relacionadas a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return Set<Project>
	 */
	public Set<Project> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getProjects();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Projeto de Pesquisa relacionadas a determinada Publica��o.
	 * 
	 * @param idPublication Integer
	 * @return Set<Project>
	 */
	public Set<Project> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getProjects();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Projeto de Pesquisa relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return Set<Project>
	 */
	public Set<Project> selectByMember(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getProjects();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Projeto de Pesquisa relacionadas a determinada Linha de Pesquisa.
	 * 
	 * @param idResearchLine Integer
	 * @return Set<Project>
	 */
	public Set<Project> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().find(idResearchLine).getProjects();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Projeto de Pesquisa relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return Set<Project>
	 */
	public Set<Project> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getProjects();
	}
}
