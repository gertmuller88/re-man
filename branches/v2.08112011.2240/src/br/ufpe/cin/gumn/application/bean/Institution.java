package br.ufpe.cin.gumn.application.bean;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe entidade Instituição.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
@Entity
@Table(name = "Institution", schema = "reman")
public class Institution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String acronym;

	private String name;

	@OneToMany(mappedBy = "institution")
	private List<Association> associations;

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
	 * @return List<Association>
	 */
	public List<Association> getAssociations() {
		return associations;
	}

	/**
	 * @param associations List<Association>
	 */
	public void setAssociations(List<Association> associations) {
		this.associations = associations;
	}
}
