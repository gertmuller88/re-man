package br.ufpe.cin.gumn.model2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.ufpe.cin.gumn.application.bean.User;

@SessionScoped
@ManagedBean
public class LoginManagedBean {
	private String login;
	private String password;
	private User user;
	private boolean access;
	
	public String logIn() {
		if(login.equals("gert") && password.equals("12345")) {
			user = new User();
			user.setLogin(login);
			user.setPassword(password);
			
			return "home";
		} else {
			access = false;
			return "login";
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}
}
