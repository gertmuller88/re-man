package br.gumn.application.control;

import java.util.Set;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import br.gumn.application.bean.User;
import br.gumn.application.persistence.UserDAO;

/**
 * Classe respons�vel pelo controle da entidade Usu�rio.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v2.08112011.2240
 */
public class UserController {
	/**
	 * M�todo respons�vel pela persist�ncia de uma inst�ncia da entidade Usu�rio.
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
	 * M�todo respons�vel pela atualiza��o de uma inst�ncia da entidade Usu�rio.
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
	 * M�todo respons�vel pela remo��o de uma inst�ncia da entidade Usu�rio.
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
	 * M�todo respons�vel pela busca de uma inst�ncia da entidade Usu�rio pela chave-prim�ria.
	 * 
	 * @param login Integer
	 * @return T
	 * @throws IllegalArgumentException
	 */
	public User find(String login) throws IllegalArgumentException {
		return new UserDAO().find(login);
	}

	/**
	 * M�todo respons�vel pela listagem de inst�ncias da entidade Usu�rio.
	 * 
	 * @return List<User>
	 * @throws IllegalArgumentException
	 */
	public Set<User> list() throws IllegalArgumentException {
		return new UserDAO().list();
	}
	
	/**
	 * M�todo respons�vel pela busca de uma inst�ncia da entidade Usu�rio relacionada a determinado Pesquisador.
	 * 
	 * @param cpfResearcher String
	 * @return User
	 * @throws IllegalArgumentException
	 */
	public User selectByReseacher(String cpfResearcher) throws IllegalArgumentException {
		return new UserDAO().selectByResearcher(cpfResearcher);
	}
	
	/**
	 * M�todo respons�vel por checar se determinado Usu�rio existe no banco de dados.
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
