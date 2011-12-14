package br.gumn.application.persistence;

import br.gumn.application.bean.User;
import br.gumn.application.persistence.util.GenericDAO;

/**
 * Classe respons�vel por fornecer encapsulamento no acesso aos dados da entidade Usu�rio.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public class UserDAO extends GenericDAO<User> {
	/**
	 * M�todo respons�vel pela busca de uma inst�ncia da entidade Usu�rio relacionada a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return User
	 * @throws IllegalArgumentException
	 */
	public User selectByResearcher(String cpfResearcher) throws IllegalArgumentException {
		return new ResearcherDAO().find(cpfResearcher).getUser();
	}
}
