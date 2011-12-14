package br.gumn.application.control;

import java.util.Set;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import br.gumn.application.bean.User;
import br.gumn.application.persistence.UserDAO;

/**
 * Classe responsável pelo controle da entidade Usuário.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v2.08112011.2240
 */
public class UserController {
	/**
	 * Método responsável pela persistência de uma instância da entidade Usuário.
	 * 
	 * @param user User
	 * @return Boolean
	 * @throws EntityExistsException
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 * @throws PersistenceException
	 */
	public boolean persist(User user) throws EntityExistsException, IllegalArgumentException, TransactionRequiredException, PersistenceException {
		return new UserDAO().persist(user);
	}

	/**
	 * Método responsável pela atualização de uma instância da entidade Usuário.
	 * 
	 * @param user User
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean merge(User user) throws IllegalArgumentException, TransactionRequiredException {
		return new UserDAO().merge(user);
	}

	/**
	 * Método responsável pela remoção de uma instância da entidade Usuário.
	 * 
	 * @param user User
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean remove(User user) throws IllegalArgumentException, TransactionRequiredException {
		return new UserDAO().remove(user);
	}

	/**
	 * Método responsável pela busca de uma instância da entidade Usuário pela chave-primária.
	 * 
	 * @param login Integer
	 * @return T
	 * @throws IllegalArgumentException
	 */
	public User find(String login) throws IllegalArgumentException {
		return new UserDAO().find(login);
	}

	/**
	 * Método responsável pela listagem de instâncias da entidade Usuário.
	 * 
	 * @return List<User>
	 * @throws IllegalArgumentException
	 */
	public Set<User> list() throws IllegalArgumentException {
		return new UserDAO().list();
	}
	
	/**
	 * Método responsável pela busca de uma instância da entidade Usuário relacionada a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return User
	 * @throws IllegalArgumentException
	 */
	public User selectByReseacher(String cpfResearcher) throws IllegalArgumentException {
		return new UserDAO().selectByResearcher(cpfResearcher);
	}
	
	/**
	 * Método responsável por checar se determinado Usuário existe no banco de dados.
	 * 
	 * @param user User
	 * @return Boolean
	 * @throws IllegalArgumentException
	 */
	public boolean check(User user) throws IllegalArgumentException {
		User tempUser = new UserDAO().find(user.getLogin());
		return tempUser.getLogin().equals(user.getLogin()) && tempUser.getPassword().equals(user.getPassword());
	}
}
