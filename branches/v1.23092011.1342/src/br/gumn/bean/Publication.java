package br.gumn.bean;

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
import br.gumn.bean.enumeration.PublicationType;

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

	@OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Address", insertable = true, updatable = true)
	private Address local;

	@OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public File getBibtex() {
		return bibtex;
	}

	public void setBibtex(File bibtex) {
		this.bibtex = bibtex;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public File getPdf() {
		return pdf;
	}

	public void setPdf(File pdf) {
		this.pdf = pdf;
	}

	public String getProceeding() {
		return proceeding;
	}

	public void setProceeding(String proceeding) {
		this.proceeding = proceeding;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PublicationType getType() {
		return type;
	}

	public void setType(PublicationType type) {
		this.type = type;
	}

	public Address getLocal() {
		return local;
	}

	public void setLocal(Address local) {
		this.local = local;
	}

	public Link getDoi() {
		return doi;
	}

	public void setDoi(Link doi) {
		this.doi = doi;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Researcher> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Researcher> authors) {
		this.authors = authors;
	}

	public List<ResearchLine> getResearchLines() {
		return researchLines;
	}

	public void setResearchLines(List<ResearchLine> researchLines) {
		this.researchLines = researchLines;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
