package br.gumn.persistence;

import java.util.List;
import br.gumn.bean.ResearchLine;
import br.gumn.persistence.util.AbstractDAO;

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
	 * @return List<ResearchLine>
	 */
	public List<ResearchLine> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getResearchLines();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Linha de Pesquisa relacionadas a determinada Publicação.
	 * 
	 * @param idPublication Integer
	 * @return List<ResearchLine>
	 */
	public List<ResearchLine> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getResearchLines();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Linha de Pesquisa relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return List<ResearchLine>
	 */
	public List<ResearchLine> selectByResearcher(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getResearchLines();
	}

	/**
	 * Método responsável pela busca de uma lista de instâncias da entidade
	 * Linha de Pesquisa relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return List<ResearchLine>
	 */
	public List<ResearchLine> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getResearchLines();
	}
}
