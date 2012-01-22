package br.gumn.jsf.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.gumn.application.bean.Researcher;
import br.gumn.application.bean.User;

/**
 * ManagedBean respons�vel pelo controle de Autentica��o.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v2.08112011.2240
 */
public class LoginManagedBean {
	private String login;
	private String password;
	private User user;
	
	/**
	 * M�todo respons�vel por efetuar a entrada do usu�rio na aplica��o.
	 * 
	 * @return String
	 */
	public String logIn() {
		if(login.equals("gertmuller88") && password.equals("12345")) {
			user = new User();
			user.setLogin(login);
			user.setPassword(password);
			user.setResearcher(new Researcher());
			user.getResearcher().setName("Gert M�ller");
			
			return "pretty:home";
		} else {
			user = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usu�rio ou senha inv�lidos."));
			return "pretty:login";
		}
	}
	
	/**
	 * M�todo respons�vel por efetuar a sa�da do usu�rio na aplica��o.
	 * 
	 * @return String
	 */
	public String logOut() {
		user = null;
		return "pretty:login";
	}

	/**
	 * @return String
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login String
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return User
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user User
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
