package br.gumn.application.persistence;

import java.util.Set;
import br.gumn.application.bean.Publication;
import br.gumn.application.persistence.util.AbstractDAO;

/**
 * Classe respons�vel por fornecer encapsulamento no acesso aos dados da
 * entidade Publica��o.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public class PublicationDAO extends AbstractDAO<Publication> {
	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Publica��o relacionadas a determinado Departamento.
	 * 
	 * @param idDepartment Integer
	 * @return Set<Publication>
	 */
	public Set<Publication> selectByDepartment(int idDepartment) {
		return new DepartmentDAO().find(idDepartment).getPublications();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Publica��o relacionadas a determinado Projeto de Pesquisa.
	 * 
	 * @param idProject Integer
	 * @return Set<Publication>
	 */
	public Set<Publication> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getPublications();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Publica��o relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return Set<Publication>
	 */
	public Set<Publication> selectByAuthor(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getPublications();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Publica��o relacionadas a determinada Linha de Pesquisa.
	 * 
	 * @param idResearchLine Integer
	 * @return Set<Publication>
	 */
	public Set<Publication> selectByResearchLine(int idResearchLine) {
		return new ResearchLineDAO().find(idResearchLine).getPublications();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Publica��o relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return Set<Publication>
	 */
	public Set<Publication> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getPublications();
	}
}
