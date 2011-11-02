package br.gumn.persistence;

import br.gumn.bean.User;
import br.gumn.persistence.util.AbstractDAO;

/**
 * Classe responsável por fornecer encapsulamento no acesso aos dados da
 * entidade Usuário.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public class UserDAO extends AbstractDAO<User> {
	/**
	 * Método responsável pela busca de uma instância da entidade
	 * Usuário relacionada a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return User
	 */
	public User selectByResearcher(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getUser();
	}
}
