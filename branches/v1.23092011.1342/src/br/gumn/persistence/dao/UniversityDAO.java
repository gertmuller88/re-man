package br.gumn.persistence.dao;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import br.gumn.bean.Department;
import br.gumn.bean.University;

public class UniversityDAO {
	public boolean insertOrUpdate(University university) {
		Configuration cfg = new Configuration();
		cfg.configure("/br/gumn/persistence/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(university);
		transaction.commit();
		session.close();
		return true;
	}
	
	public static void main(String[] args)
	{
		University u = new University();
		u.setAcronym("UFPE");
		u.setName("Universidade Federal de Pernambuco");
		
		Department d = new Department();
		d.setAcronym("CIn");
		d.setName("Centro de Informática");
		d.setUniversity(u);
		
		u.setDepartments(new ArrayList<Department>());
		u.getDepartments().add(d);
		
		UniversityDAO ud = new UniversityDAO();
		ud.insertOrUpdate(u);
	}
}
