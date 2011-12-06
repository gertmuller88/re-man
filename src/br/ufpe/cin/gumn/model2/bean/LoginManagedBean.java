package br.ufpe.cin.gumn.model2.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.ufpe.cin.gumn.application.bean.Researcher;
import br.ufpe.cin.gumn.application.bean.User;

public class LoginManagedBean {
	private String login;
	private String password;
	private User user;
	
	public String logIn() {
		if(login.equals("gertmuller88") && password.equals("12345")) {
			user = new User();
			user.setLogin(login);
			user.setPassword(password);
			user.setResearcher(new Researcher());
			user.getResearcher().setName("Gert Müller");
			
			return "pretty:home";
		} else {
			user = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário ou senha inválidos."));
			return "pretty:login";
		}
	}
	
	public String logOut() {
		user = null;
		return "pretty:login";
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
}
