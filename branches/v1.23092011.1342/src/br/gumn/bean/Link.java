package br.gumn.bean;

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

@Entity
@Table(name = "Link", schema = "reman")
public class Link {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String description;

	private String title;

	private String url;

	@OneToOne(mappedBy = "site")
	private Department department;

	@OneToOne(mappedBy = "doi")
	private Publication publication;

	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Researcher", insertable = true, updatable = true)
	private Researcher researcher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public Researcher getResearcher() {
		return researcher;
	}

	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}
}
