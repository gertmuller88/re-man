package br.gumn.application.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe entidade Link.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
@Entity
@Table(name = "Link", schema = "reman")
public class Link {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String description;

	private String title;

	private String url;

	@OneToOne(mappedBy = "site", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Department department;

	@OneToOne(mappedBy = "doi", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Publication publication;

	@ManyToOne(optional = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Researcher", insertable = true, updatable = true)
	private Researcher researcher;

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
	public String getDescription() {
		return description;
	}

	/**
	 * @param description String
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title String
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return String
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url String
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return Department 
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department Department
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return Publication
	 */
	public Publication getPublication() {
		return publication;
	}

	/**
	 * @param publication Publication
	 */
	public void setPublication(Publication publication) {
		this.publication = publication;
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
