package br.gumn.jsf.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.gumn.application.Facade;
import br.gumn.application.bean.Researcher;
import br.gumn.application.bean.User;
import br.gumn.jsf.message.NavigationRules;

/**
 * ManagedBean responsável pelo controle de Autenticação.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v2.08112011.2240
 */
public class LoginManagedBean {
	private String login;
	private String password;
	private User user;
	
	/**
	 * Método responsável por efetuar a entrada do usuário na aplicação.
	 * 
	 * @return String
	 */
	public String logIn() {
		User user = new User();
		user.setLogin(this.login);
		user.setPassword(this.password);
		
		if(Facade.getInstance().checkUser(user)) {
			this.user = user;
			this.user.setResearcher(new Researcher());
			this.user.getResearcher().setName("Gert Müller");
			
			return NavigationRules.home;
		} else {
			this.user = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário ou senha inválidos."));
			
			return NavigationRules.login;
		}
	}
	
	/**
	 * Método responsável por efetuar a saída do usuário na aplicação.
	 * 
	 * @return String
	 */
	public String logOut() {
		user = null;
		
		return NavigationRules.login;
	}

	/**
	 * @return String
	 */
	public String getLogin() {
		return this.login;
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
		return this.password;
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
		return this.user;
	}

	/**
	 * @param user User
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
