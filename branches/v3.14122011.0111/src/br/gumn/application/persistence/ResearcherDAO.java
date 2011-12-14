package br.gumn.application.persistence;

import java.util.Set;
import br.gumn.application.bean.Researcher;
import br.gumn.application.persistence.util.GenericDAO;

/**
 * Classe respons�vel por fornecer encapsulamento no acesso aos dados da entidade Pesquisador.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public class ResearcherDAO extends GenericDAO<Researcher> {
	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Pesquisador relacionadas a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return Set<Researcher>
	 * @throws IllegalArgumentException
	 */
	public Set<Researcher> selectByDepartment(int idDepartment) throws IllegalArgumentException {
		return new DepartmentDAO().find(idDepartment).getMembers();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Pesquisador relacionadas a determinado Projeto de Pesquisa.
	 * 
	 * @param idProject Integer
	 * @return Set<Researcher>
	 * @throws IllegalArgumentException
	 */
	public Set<Researcher> selectByProject(int idProject) throws IllegalArgumentException {
		return new ProjectDAO().find(idProject).getMembers();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Pesquisador relacionadas a determinada Publica��o.
	 * 
	 * @param idPublication Integer
	 * @return Set<Researcher>
	 * @throws IllegalArgumentException
	 */
	public Set<Researcher> selectByPublication(int idPublication) throws IllegalArgumentException {
		return new PublicationDAO().find(idPublication).getAuthors();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Pesquisador relacionadas a determinada Linha de Pesquisa.
	 * 
	 * @param idResearchLine Integer
	 * @return Set<Researcher>
	 * @throws IllegalArgumentException
	 */
	public Set<Researcher> selectByResearchLine(int idResearchLine) throws IllegalArgumentException {
		return new ResearchLineDAO().find(idResearchLine).getResearchers();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Pesquisador relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return Set<Researcher>
	 * @throws IllegalArgumentException
	 */
	public Set<Researcher> selectByTeam(int idTeam) throws IllegalArgumentException {
		return new TeamDAO().find(idTeam).getMembers();
	}

	/**
	 * M�todo respons�vel pela busca de uma inst�ncia da entidade Pesquisador relacionada a determinado Usu�rio.
	 * 
	 * @param loginUser String
	 * @return Researcher
	 * @throws IllegalArgumentException
	 */
	public Researcher selectByUser(String loginUser) throws IllegalArgumentException {
		return new UserDAO().find(loginUser).getResearcher();
	}
}
