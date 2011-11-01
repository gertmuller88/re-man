package br.gumn.persistence;

import java.util.List;
import br.gumn.bean.Publication;
import br.gumn.persistence.util.AbstractDAO;

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
	 * @return List<Publication>
	 */
	public List<Publication> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getPublications();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Publicação relacionadas a determinado Projeto de Pesquisa.
	 * 
	 * @param idProject Integer
	 * @return List<Publication>
	 */
	public List<Publication> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getPublications();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Publicação relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return List<Publication>
	 */
	public List<Publication> selectByAuthor(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getPublications();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Publicação relacionadas a determinada Linha de Pesquisa.
	 * 
	 * @param idResearchLine Integer
	 * @return List<Publication>
	 */
	public List<Publication> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().find(idResearchLine).getPublications();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Publicação relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return List<Publication>
	 */
	public List<Publication> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getPublications();
	}
}
