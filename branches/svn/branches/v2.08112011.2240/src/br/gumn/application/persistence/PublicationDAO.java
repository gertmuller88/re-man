package br.gumn.application.persistence;

import java.util.Set;
import br.gumn.application.bean.Publication;
import br.gumn.application.persistence.util.AbstractDAO;

/**
 * Classe responsável por fornecer encapsulamento no acesso aos dados da
 * entidade Publicação.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public class PublicationDAO extends AbstractDAO<Publication> {
	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Publicação relacionadas a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return Set<Publication>
	 */
	public Set<Publication> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getPublications();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Publicação relacionadas a determinado Projeto de Pesquisa.
	 * 
	 * @param idProject Integer
	 * @return Set<Publication>
	 */
	public Set<Publication> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getPublications();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Publicação relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return Set<Publication>
	 */
	public Set<Publication> selectByAuthor(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getPublications();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Publicação relacionadas a determinada Linha de Pesquisa.
	 * 
	 * @param idResearchLine Integer
	 * @return Set<Publication>
	 */
	public Set<Publication> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().find(idResearchLine).getPublications();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Publicação relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return Set<Publication>
	 */
	public Set<Publication> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getPublications();
	}
}
