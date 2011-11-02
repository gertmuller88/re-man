package br.gumn.persistence;

import br.gumn.bean.User;
import br.gumn.persistence.util.AbstractDAO;

/**
 * Classe respons�vel por fornecer encapsulamento no acesso aos dados da
 * entidade Usu�rio.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public class UserDAO extends AbstractDAO<User> {
	/**
	 * M�todo respons�vel pela busca de uma inst�ncia da entidade
	 * Usu�rio relacionada a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return User
	 */
	public User selectByResearcher(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getUser();
	}
}
