package br.gumn.bean;

import java.io.File;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import br.gumn.bean.enumeration.Degree;

/**
 * Classe entidade Pesquisador.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
@Entity
@Table(name = "Researcher", schema = "reman")
public class Researcher {

	@Id
	private String cpf;

	private String bankData;

	private String brief;

	private String email;

	private File image;

	private String name;

	private String occupation;

	private String rg;

	@Enumerated(EnumType.STRING)
	private Degree degree;

	@OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Address", insertable = true, updatable = true)
	private Address address;

	@OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_User", insertable = true, updatable = true)
	private User user;

	@ManyToMany(mappedBy = "members")
	private List<Department> departments;

	@ManyToMany(mappedBy = "members")
	private List<Project> projects;

	@ManyToMany(mappedBy = "authors")
	private List<Publication> publications;

	@ManyToMany
	@JoinTable(name = "Researcher_ResearchLine", schema = "reman", joinColumns = @JoinColumn(name = "id_Researcher"), inverseJoinColumns = @JoinColumn(name = "id_ResearchLine"))
	private List<ResearchLine> researchLines;

	@ManyToMany
	@JoinTable(name = "Researcher_Team", schema = "reman", joinColumns = @JoinColumn(name = "id_Researcher"), inverseJoinColumns = @JoinColumn(name = "id_Team"))
	private List<Team> teams;

	@OneToMany(mappedBy = "researcher")
	private List<Association> associations;

	@OneToMany(mappedBy = "researcher")
	private List<Link> links;

	@OneToMany(mappedBy = "advisor")
	private List<Title> supervisionedTitles;

	@OneToMany(mappedBy = "researcher")
	private List<Title> titles;

	/**
	 * @return String
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf String
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return String
	 */
	public String getBankData() {
		return bankData;
	}

	/**
	 * @param bankData String
	 */
	public void setBankData(String bankData) {
		this.bankData = bankData;
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
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email String
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return File
	 */
	public File getImage() {
		return image;
	}

	/**
	 * @param image File
	 */
	public void setImage(File image) {
		this.image = image;
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
	 * @return String
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation String
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * @return String
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * @param rg String
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * @return Degree
	 */
	public Degree getDegree() {
		return degree;
	}

	/**
	 * @param degree Degree
	 */
	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	/**
	 * @return Address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address Address
	 */
	public void setAddress(Address address) {
		this.address = address;
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
	 * @return List<Link>
	 */
	public List<Link> getLinks() {
		return links;
	}

	/**
	 * @param links List<Link>
	 */
	public void setLinks(List<Link> links) {
		this.links = links;
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
	 * @return List<Publication>
	 */
	public List<Publication> getPublications() {
		return publications;
	}

	/**
	 * @param publications List<Publication>
	 */
	public void setPublications(List<Publication> publications) {
		this.publications = publications;
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

	/**
	 * @return List<Title>
	 */
	public List<Title> getTitles() {
		return titles;
	}

	/**
	 * @param titles List<Title>
	 */
	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	/**
	 * @return List<Title>
	 */
	public List<Title> getSupervisionedTitles() {
		return supervisionedTitles;
	}

	/**
	 * @param supervisionedTitles List<Title>
	 */
	public void setSupervisionedTitles(List<Title> supervisionedTitles) {
		this.supervisionedTitles = supervisionedTitles;
	}

	/**
	 * @return User
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user User
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
