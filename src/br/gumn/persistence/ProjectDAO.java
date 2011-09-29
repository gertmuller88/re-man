package br.gumn.persistence;

import org.hibernate.Session;
import br.gumn.bean.Project;
import br.gumn.persistence.hibernate.GenericHibernateDAO;
import br.gumn.persistence.hibernate.GenericHibernateSessionFactory;

public class ProjectDAO extends GenericHibernateDAO<Project> {
	public Project selectById(int id) {
		Session session = GenericHibernateSessionFactory.openSession();
		return (Project) session.load(Project.class, id);
	}
}
