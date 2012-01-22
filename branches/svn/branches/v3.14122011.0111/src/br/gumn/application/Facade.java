package br.gumn.application;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import br.gumn.application.bean.User;
import br.gumn.application.control.UserController;

/**
 * Classe responsável por fornecer ligação entre a camada de visualização e de controle, seguindo o padrão MVC.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public class Facade {
	private static Facade facade;
	
	/**
	 * Método responsável pela instanciação da classe.
	 */
	private Facade() {}
	
	/**
	 * Método responsável por encapsular e restrigir a criação e o acesso às instâncias desta classe, seguindo o padrão Singleton.
	 * 
	 * @return Facade
	 */
	public static Facade getInstance() {
		if(facade==null) {
			facade = new Facade();
		}
		return facade;
	}
	
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
	public boolean persistUser(User user) throws EntityExistsException, IllegalArgumentException, TransactionRequiredException, PersistenceException {
		return new UserController().persist(user);
	}
	
	/**
	 * Método responsável pela atualização de uma instância da entidade Usuário.
	 * 
	 * @param user User
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean mergeUser(User user) throws IllegalArgumentException, TransactionRequiredException {
		return new UserController().merge(user);
	}
	
	/**
	 * Método responsável pela remoção de uma instância da entidade Usuário.
	 * 
	 * @param user User
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean removeUser(User user) throws IllegalArgumentException, TransactionRequiredException {
		return new UserController().remove(user);
	}
	
	/**
	 * Método responsável por checar se determinado Usuário existe no banco de dados.
	 * 
	 * @param user User
	 * @return Boolean
	 * @throws IllegalArgumentException
	 */
	public boolean checkUser(User user) throws IllegalArgumentException {
		return new UserController().check(user);
	}
	
	/**
	 * Método responsável pela busca de uma instância da entidade Usuário pela chave-primária.
	 * 
	 * @param login String
	 * @return T
	 * @throws IllegalArgumentException
	 */
	public User findUser(String login) throws IllegalArgumentException {
		return new UserController().find(login);
	}
}
