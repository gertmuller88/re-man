package br.gumn.application;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import br.gumn.application.bean.User;
import br.gumn.application.control.UserController;

/**
 * Classe respons�vel por fornecer liga��o entre a camada de visualiza��o e de controle, seguindo o padr�o MVC.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public class Facade {
	private static Facade facade;
	
	/**
	 * M�todo respons�vel pela instancia��o da classe.
	 */
	private Facade() {}
	
	/**
	 * M�todo respons�vel por encapsular e restrigir a cria��o e o acesso �s inst�ncias desta classe, seguindo o padr�o Singleton.
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
	 * M�todo respons�vel pela persist�ncia de uma inst�ncia da entidade Usu�rio.
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
	 * M�todo respons�vel pela atualiza��o de uma inst�ncia da entidade Usu�rio.
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
	 * M�todo respons�vel pela remo��o de uma inst�ncia da entidade Usu�rio.
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
	 * M�todo respons�vel por checar se determinado Usu�rio existe no banco de dados.
	 * 
	 * @param user User
	 * @return Boolean
	 * @throws IllegalArgumentException
	 */
	public boolean checkUser(User user) throws IllegalArgumentException {
		return new UserController().check(user);
	}
	
	/**
	 * M�todo respons�vel pela busca de uma inst�ncia da entidade Usu�rio pela chave-prim�ria.
	 * 
	 * @param login String
	 * @return T
	 * @throws IllegalArgumentException
	 */
	public User findUser(String login) throws IllegalArgumentException {
		return new UserController().find(login);
	}
}
