package br.gumn.application.persistence;

import java.util.List;

import br.gumn.application.bean.Researcher;
import br.gumn.application.persistence.util.AbstractDAO;

/**
 * Classe respons�vel por fornecer encapsulamento no acesso aos dados da
 * entidade Pesquisador.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public class ResearcherDAO extends AbstractDAO<Researcher> {
	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Pesquisador relacionadas a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return List<Researcher>
	 */
	public List<Researcher> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getMembers();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Pesquisador relacionadas a determinado Projeto de Pesquisa.
	 * 
	 * @param idProject Integer
	 * @return List<Researcher>
	 */
	public List<Researcher> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getMembers();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Pesquisador relacionadas a determinada Publica��o.
	 * 
	 * @param idPublication Integer
	 * @return List<Researcher>
	 */
	public List<Researcher> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getAuthors();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Pesquisador relacionadas a determinada Linha de Pesquisa.
	 * 
	 * @param idResearchLine Integer
	 * @return List<Researcher>
	 */
	public List<Researcher> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().find(idResearchLine).getResearchers();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Pesquisador relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return List<Researcher>
	 */
	public List<Researcher> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getMembers();
	}

	/**
	 * M�todo respons�vel pela busca de uma inst�ncia da entidade
	 * Pesquisador relacionada a determinado Usu�rio.
	 * 
	 * @param loginUser String
	 * @return Researcher
	 */
	public Researcher selectByUser(String loginUser) {
		return new UserDAO().find(loginUser).getResearcher();
	}
}
