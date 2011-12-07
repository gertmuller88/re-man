package br.gumn.application.bean;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * Classe entidade Universidade.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
@Entity
@Table(name = "University", schema = "reman")
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String acronym;

	private String name;

	@OneToMany(mappedBy = "university")
	@OrderBy("name")
	private Set<Department> departments;

	/**
	 * @return Integer
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id Integer
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return String
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * @param acronym String
	 */
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	/**
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Set<Department>
	 */
	public Set<Department> getDepartments() {
		return departments;
	}

	/**
	 * @param departments Set<Department>
	 */
	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}
}
