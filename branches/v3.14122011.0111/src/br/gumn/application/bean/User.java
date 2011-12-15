package br.gumn.application.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import br.gumn.application.bean.enumeration.UserLevel;

/**
 * Classe entidade Usuário.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
@Entity
@Table(name = "User", schema = "reman")
public class User {

	@Id
	private String login;

	private String password;

	@Enumerated
	private UserLevel userLevel;

	@OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Researcher researcher;

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
	 * @return UserLevel
	 */
	public UserLevel getUserLevel() {
		return userLevel;
	}

	/**
	 * @param userLevel UserLevel
	 */
	public void setUserLevel(UserLevel userLevel) {
		this.userLevel = userLevel;
	}

	/**
	 * @return Researcher
	 */
	public Researcher getResearcher() {
		return researcher;
	}

	/**
	 * @param researcher Researcher
	 */
	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}
}
