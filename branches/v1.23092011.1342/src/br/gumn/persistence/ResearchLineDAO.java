package br.gumn.persistence;

import java.util.List;
import br.gumn.bean.ResearchLine;
import br.gumn.persistence.util.AbstractDAO;

/**
 * Classe respons�vel por fornecer encapsulamento no acesso aos dados da
 * entidade Linha de Pesquisa.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public class ResearchLineDAO extends AbstractDAO<ResearchLine> {
	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Linha de Pesquisa relacionadas a determinado Projeto de Pesquisa.
	 * 
	 * @param idProject Integer
	 * @return List<ResearchLine>
	 */
	public List<ResearchLine> selectByProject(int idProject) {
		return new ProjectDAO().find(idProject).getResearchLines();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Linha de Pesquisa relacionadas a determinada Publica��o.
	 * 
	 * @param idPublication Integer
	 * @return List<ResearchLine>
	 */
	public List<ResearchLine> selectByPublication(int idPublication) {
		return new PublicationDAO().find(idPublication).getResearchLines();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Linha de Pesquisa relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return List<ResearchLine>
	 */
	public List<ResearchLine> selectByResearcher(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getResearchLines();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade
	 * Linha de Pesquisa relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return List<ResearchLine>
	 */
	public List<ResearchLine> selectByTeam(int idTeam) {
		return new TeamDAO().find(idTeam).getResearchLines();
	}
}
