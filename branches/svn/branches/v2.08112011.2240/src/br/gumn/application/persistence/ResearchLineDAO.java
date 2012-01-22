package br.gumn.application.persistence;

import java.util.Set;
import br.gumn.application.bean.ResearchLine;
import br.gumn.application.persistence.util.AbstractDAO;

/**
 * Classe responsável por fornecer encapsulamento no acesso aos dados da
 * entidade Linha de Pesquisa.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public class ResearchLineDAO extends AbstractDAO<ResearchLine> {
	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Linha de Pesquisa relacionadas a determinado Projeto de Pesquisa.
	 * 
	 * @param idProject Integer
	 * @return Set<ResearchLine>
	 */
	public Set<ResearchLine> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getResearchLines();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Linha de Pesquisa relacionadas a determinada Publicação.
	 * 
	 * @param idPublication Integer
	 * @return Set<ResearchLine>
	 */
	public Set<ResearchLine> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getResearchLines();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Linha de Pesquisa relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return Set<ResearchLine>
	 */
	public Set<ResearchLine> selectByResearcher(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getResearchLines();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Linha de Pesquisa relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return Set<ResearchLine>
	 */
	public Set<ResearchLine> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getResearchLines();
	}
}
