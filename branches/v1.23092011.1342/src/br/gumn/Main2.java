package br.gumn;

import br.gumn.bean.Department;
import br.gumn.bean.University;
import br.gumn.persistence.hibernate.GenericHibernateDAO;

public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		University u1 = new University();
		u1.setAcronym("UPE");
		u1.setName("Universidade de Pernambuco");
		
		University u2 = new University();
		u2.setAcronym("UFPE");
		u2.setName("Universidade Federal de Pernambuco");
		
		University u3 = new University();
		u3.setAcronym("FAVIP");
		u3.setName("Faculdade do Vale do Ipojuca");
		
		Department d1 = new Department();
		d1.setAcronym("Poli");
		d1.setName("Escola Politécnica de Pernambuco");
		d1.setUniversity(u1);
		
		Department d2 = new Department();
		d2.setAcronym("CIn");
		d2.setName("Centro de Informática");
		d2.setUniversity(u2);
		
		Department d3 = new Department();
		d3.setAcronym("ND");
		d3.setName("Núcleo de Direito");
		d3.setUniversity(u3);
		
		GenericHibernateDAO<Department> g = new GenericHibernateDAO<Department>();
		g.insert(d1);
		g.insert(d2);
		g.insert(d3);
	}

}
