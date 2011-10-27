package br.gumn.persistence;

import br.gumn.bean.User;
import br.gumn.persistence.util.AbstractDAO;

public class UserDAO extends AbstractDAO<User> {
	public User selectByResearcher(String cpfResearcher) {
		return new ResearcherDAO().find(cpfResearcher).getUser();
	}
}
