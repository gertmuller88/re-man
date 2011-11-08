package br.gumn.application.bean;

import java.io.File;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.gumn.application.bean.enumeration.PublicationType;

/**
 * Classe entidade Publicação.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
@Entity
@Table(name = "Publication", schema = "reman")
public class Publication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private File bibtex;

	private String brief;

	private Date date;

	private int edition;

	private File pdf;

	private String proceeding;

	private String publishingHouse;

	private String title;

	@Enumerated(EnumType.STRING)
	private PublicationType type;

	@OneToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Address", insertable = true, updatable = true)
	private Address local;

	@OneToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Link", insertable = true, updatable = true)
	private Link doi;

	@ManyToMany(mappedBy = "publications")
	private List<Department> departments;

	@ManyToMany(mappedBy = "publications")
	private List<Project> projects;

	@ManyToMany
	@JoinTable(name = "Publication_Researcher", schema = "reman", joinColumns = @JoinColumn(name = "id_Publication"), inverseJoinColumns = @JoinColumn(name = "id_Researcher"))
	private List<Researcher> authors;

	@ManyToMany
	@JoinTable(name = "Publication_ResearchLine", schema = "reman", joinColumns = @JoinColumn(name = "id_Publication"), inverseJoinColumns = @JoinColumn(name = "id_ResearchLine"))
	private List<ResearchLine> researchLines;

	@ManyToMany
	@JoinTable(name = "Publication_Team", schema = "reman", joinColumns = @JoinColumn(name = "id_Publication"), inverseJoinColumns = @JoinColumn(name = "id_Team"))
	private List<Team> teams;

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
	 * @return File
	 */
	public File getBibtex() {
		return bibtex;
	}

	/**
	 * @param bibtex File
	 */
	public void setBibtex(File bibtex) {
		this.bibtex = bibtex;
	}

	/**
	 * @return String
	 */
	public String getBrief() {
		return brief;
	}

	/**
	 * @param brief String
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}

	/**
	 * @return Date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date Date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return Integer
	 */
	public int getEdition() {
		return edition;
	}

	/**
	 * @param edition Integer
	 */
	public void setEdition(int edition) {
		this.edition = edition;
	}

	/**
	 * @return File
	 */
	public File getPdf() {
		return pdf;
	}

	/**
	 * @param pdf File
	 */
	public void setPdf(File pdf) {
		this.pdf = pdf;
	}

	/**
	 * @return String
	 */
	public String getProceeding() {
		return proceeding;
	}

	/**
	 * @param proceeding String
	 */
	public void setProceeding(String proceeding) {
		this.proceeding = proceeding;
	}

	/**
	 * @return String
	 */
	public String getPublishingHouse() {
		return publishingHouse;
	}

	/**
	 * @param publishingHouse String
	 */
	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
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
	 * @return PublicationType
	 */
	public PublicationType getType() {
		return type;
	}

	/**
	 * @param type PublicationType
	 */
	public void setType(PublicationType type) {
		this.type = type;
	}

	/**
	 * @return Address
	 */
	public Address getLocal() {
		return local;
	}

	/**
	 * @param local Address
	 */
	public void setLocal(Address local) {
		this.local = local;
	}

	/**
	 * @return Link
	 */
	public Link getDoi() {
		return doi;
	}

	/**
	 * @param doi Link
	 */
	public void setDoi(Link doi) {
		this.doi = doi;
	}

	/**
	 * @return List<Department>
	 */
	public List<Department> getDepartments() {
		return departments;
	}

	/**
	 * @param departments List<Department>
	 */
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	/**
	 * @return List<Project>
	 */
	public List<Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects List<Project>
	 */
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	/**
	 * @return List<Researcher>
	 */
	public List<Researcher> getAuthors() {
		return authors;
	}

	/**
	 * @param authors List<Researcher>
	 */
	public void setAuthors(List<Researcher> authors) {
		this.authors = authors;
	}

	/**
	 * @return List<ResearchLine>
	 */
	public List<ResearchLine> getResearchLines() {
		return researchLines;
	}

	/**
	 * @param researchLines List<ResearchLine>
	 */
	public void setResearchLines(List<ResearchLine> researchLines) {
		this.researchLines = researchLines;
	}

	/**
	 * @return List<Team>
	 */
	public List<Team> getTeams() {
		return teams;
	}

	/**
	 * @param teams List<Team>
	 */
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
