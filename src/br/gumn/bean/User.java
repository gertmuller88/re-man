package br.gumn.bean;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import br.gumn.bean.enumeration.UserLevel;

@Entity
@Table(name = "User", schema = "reman")
public class User {

	@Id
	private String login;

	private String password;

	@Enumerated
	private UserLevel userLevel;

	@OneToOne(mappedBy = "user")
	@Cascade(CascadeType.ALL)
	private Researcher researcher;

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

	public UserLevel getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(UserLevel userLevel) {
		this.userLevel = userLevel;
	}

	public Researcher getResearcher() {
		return researcher;
	}

	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}
}
