package br.gumn.application.persistence;

import br.gumn.application.bean.User;
import br.gumn.application.persistence.util.GenericDAO;

/**
 * Classe responsável por fornecer encapsulamento no acesso aos dados da entidade Usuário.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public class UserDAO extends GenericDAO<User> {
	/**
	 * Método responsável pela busca de uma instância da entidade Usuário relacionada a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return User
	 * @throws IllegalArgumentException
	 */
	public User selectByResearcher(String cpfResearcher) throws IllegalArgumentException {
		return new ResearcherDAO().find(cpfResearcher).getUser();
	}
}
