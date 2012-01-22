package br.gumn.application.persistence;

import java.util.Set;
import br.gumn.application.bean.Researcher;
import br.gumn.application.persistence.util.GenericDAO;

/**
 * Classe responsável por fornecer encapsulamento no acesso aos dados da entidade Pesquisador.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public class ResearcherDAO extends GenericDAO<Researcher> {
	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade Pesquisador relacionadas a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return Set<Researcher>
	 * @throws IllegalArgumentException
	 */
	public Set<Researcher> selectByDepartment(int idDepartment) throws IllegalArgumentException {
		return new DepartmentDAO().find(idDepartment).getMembers();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade Pesquisador relacionadas a determinado Projeto de Pesquisa.
	 * 
	 * @param idProject Integer
	 * @return Set<Researcher>
	 * @throws IllegalArgumentException
	 */
	public Set<Researcher> selectByProject(int idProject) throws IllegalArgumentException {
		return new ProjectDAO().find(idProject).getMembers();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade Pesquisador relacionadas a determinada Publicação.
	 * 
	 * @param idPublication Integer
	 * @return Set<Researcher>
	 * @throws IllegalArgumentException
	 */
	public Set<Researcher> selectByPublication(int idPublication) throws IllegalArgumentException {
		return new PublicationDAO().find(idPublication).getAuthors();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade Pesquisador relacionadas a determinada Linha de Pesquisa.
	 * 
	 * @param idResearchLine Integer
	 * @return Set<Researcher>
	 * @throws IllegalArgumentException
	 */
	public Set<Researcher> selectByResearchLine(int idResearchLine) throws IllegalArgumentException {
		return new ResearchLineDAO().find(idResearchLine).getResearchers();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade Pesquisador relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return Set<Researcher>
	 * @throws IllegalArgumentException
	 */
	public Set<Researcher> selectByTeam(int idTeam) throws IllegalArgumentException {
		return new TeamDAO().find(idTeam).getMembers();
	}

	/**
	 * Método responsável pela busca de uma instância da entidade Pesquisador relacionada a determinado Usuário.
	 * 
	 * @param loginUser String
	 * @return Researcher
	 * @throws IllegalArgumentException
	 */
	public Researcher selectByUser(String loginUser) throws IllegalArgumentException {
		return new UserDAO().find(loginUser).getResearcher();
	}
}
