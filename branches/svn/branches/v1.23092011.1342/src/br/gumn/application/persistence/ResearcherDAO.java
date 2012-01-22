package br.gumn.application.persistence;

import java.util.List;

import br.gumn.application.bean.Researcher;
import br.gumn.application.persistence.util.AbstractDAO;

/**
 * Classe responsável por fornecer encapsulamento no acesso aos dados da
 * entidade Pesquisador.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public class ResearcherDAO extends AbstractDAO<Researcher> {
	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Pesquisador relacionadas a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return List<Researcher>
	 */
	public List<Researcher> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getMembers();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Pesquisador relacionadas a determinado Projeto de Pesquisa.
	 * 
	 * @param idProject Integer
	 * @return List<Researcher>
	 */
	public List<Researcher> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getMembers();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Pesquisador relacionadas a determinada Publicação.
	 * 
	 * @param idPublication Integer
	 * @return List<Researcher>
	 */
	public List<Researcher> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getAuthors();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Pesquisador relacionadas a determinada Linha de Pesquisa.
	 * 
	 * @param idResearchLine Integer
	 * @return List<Researcher>
	 */
	public List<Researcher> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().find(idResearchLine).getResearchers();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Pesquisador relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return List<Researcher>
	 */
	public List<Researcher> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getMembers();
	}

	/**
	 * Método responsável pela busca de uma instância da entidade
	 * Pesquisador relacionada a determinado Usuário.
	 * 
	 * @param loginUser String
	 * @return Researcher
	 */
	public Researcher selectByUser(String loginUser) {
		return new UserDAO().find(loginUser).getResearcher();
	}
}
