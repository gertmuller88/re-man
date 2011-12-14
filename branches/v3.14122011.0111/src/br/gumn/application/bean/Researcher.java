package br.gumn.application.bean;

import java.io.File;
import java.util.Set;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import br.gumn.application.bean.enumeration.Degree;

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

	@OneToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Address", insertable = true, updatable = true)
	private Address address;

	@OneToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_User", insertable = true, updatable = true)
	private User user;

	@ManyToMany(mappedBy = "members")
	@OrderBy("name")
	private Set<Department> departments;

	@ManyToMany(mappedBy = "members")
	@OrderBy("name")
	private Set<Project> projects;

	@ManyToMany(mappedBy = "authors")
	@OrderBy("date")
	private Set<Publication> publications;

	@ManyToMany
	@OrderBy("title")
	@JoinTable(name = "Researcher_ResearchLine", schema = "reman", joinColumns = @JoinColumn(name = "id_Researcher"), inverseJoinColumns = @JoinColumn(name = "id_ResearchLine"))
	private Set<ResearchLine> researchLines;

	@ManyToMany
	@OrderBy("name")
	@JoinTable(name = "Researcher_Team", schema = "reman", joinColumns = @JoinColumn(name = "id_Researcher"), inverseJoinColumns = @JoinColumn(name = "id_Team"))
	private Set<Team> teams;

	@OneToMany(mappedBy = "researcher")
	@OrderBy("date")
	private Set<Association> associations;

	@OneToMany(mappedBy = "researcher")
	@OrderBy("title")
	private Set<Link> links;

	@OneToMany(mappedBy = "advisor")
	@OrderBy("date")
	private Set<Title> supervisionedTitles;

	@OneToMany(mappedBy = "researcher")
	@OrderBy("date")
	private Set<Title> titles;

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
	 * @return Set<Association>
	 */
	public Set<Association> getAssociations() {
		return associations;
	}

	/**
	 * @param associations Set<Association>
	 */
	public void setAssociations(Set<Association> associations) {
		this.associations = associations;
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

	/**
	 * @return Set<Link>
	 */
	public Set<Link> getLinks() {
		return links;
	}

	/**
	 * @param links Set<Link>
	 */
	public void setLinks(Set<Link> links) {
		this.links = links;
	}

	/**
	 * @return Set<Project>
	 */
	public Set<Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects Set<Project>
	 */
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	/**
	 * @return Set<Publication>
	 */
	public Set<Publication> getPublications() {
		return publications;
	}

	/**
	 * @param publications Set<Publication>
	 */
	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}

	/**
	 * @return Set<ResearchLine>
	 */
	public Set<ResearchLine> getResearchLines() {
		return researchLines;
	}

	/**
	 * @param researchLines Set<ResearchLine>
	 */
	public void setResearchLines(Set<ResearchLine> researchLines) {
		this.researchLines = researchLines;
	}

	/**
	 * @return Set<Team>
	 */
	public Set<Team> getTeams() {
		return teams;
	}

	/**
	 * @param teams Set<Team>
	 */
	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	/**
	 * @return Set<Title>
	 */
	public Set<Title> getTitles() {
		return titles;
	}

	/**
	 * @param titles Set<Title>
	 */
	public void setTitles(Set<Title> titles) {
		this.titles = titles;
	}

	/**
	 * @return Set<Title>
	 */
	public Set<Title> getSupervisionedTitles() {
		return supervisionedTitles;
	}

	/**
	 * @param supervisionedTitles Set<Title>
	 */
	public void setSupervisionedTitles(Set<Title> supervisionedTitles) {
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
