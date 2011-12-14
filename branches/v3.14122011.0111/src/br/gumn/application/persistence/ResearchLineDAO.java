package br.gumn.application.persistence;

import java.util.Set;
import br.gumn.application.bean.ResearchLine;
import br.gumn.application.persistence.util.GenericDAO;

/**
 * Classe respons�vel por fornecer encapsulamento no acesso aos dados da entidade Linha de Pesquisa.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public class ResearchLineDAO extends GenericDAO<ResearchLine> {
	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Linha de Pesquisa relacionadas a determinado Projeto de Pesquisa.
	 * 
	 * @param idProject Integer
	 * @return Set<ResearchLine>
	 * @throws IllegalArgumentException
	 */
	public Set<ResearchLine> selectByProject(int idProject) throws IllegalArgumentException {
		return new ProjectDAO().find(idProject).getResearchLines();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Linha de Pesquisa relacionadas a determinada Publica��o.
	 * 
	 * @param idPublication Integer
	 * @return Set<ResearchLine>
	 * @throws IllegalArgumentException
	 */
	public Set<ResearchLine> selectByPublication(int idPublication) throws IllegalArgumentException {
		return new PublicationDAO().find(idPublication).getResearchLines();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Linha de Pesquisa relacionadas a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return Set<ResearchLine>
	 * @throws IllegalArgumentException
	 */
	public Set<ResearchLine> selectByResearcher(String cpfResearcher) throws IllegalArgumentException {
		return new ResearcherDAO().find(cpfResearcher).getResearchLines();
	}

	/**
	 * M�todo respons�vel pela busca de uma lista de inst�ncias da entidade Linha de Pesquisa relacionadas a determinado Grupo/Time de Pesquisa.
	 * 
	 * @param idTeam Integer
	 * @return Set<ResearchLine>
	 * @throws IllegalArgumentException
	 */
	public Set<ResearchLine> selectByTeam(int idTeam) throws IllegalArgumentException {
		return new TeamDAO().find(idTeam).getResearchLines();
	}
}
