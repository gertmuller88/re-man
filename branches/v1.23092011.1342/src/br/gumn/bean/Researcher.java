package br.gumn.bean;

import java.io.File;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import br.gumn.bean.enumeration.Degree;

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

	@Enumerated
	private Degree degree;

	@OneToOne
	@JoinColumn(name = "id_Address", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.ALL)
	private Address address;

	@OneToMany(mappedBy = "researcher", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private List<Association> associations;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "Department_Researcher", schema = "reman", joinColumns = @JoinColumn(name = "id_Researcher"), inverseJoinColumns = @JoinColumn(name = "id_Department"))
	private List<Department> departments;

	@OneToMany(mappedBy = "researcher", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private List<Link> links;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "Project_Researcher", schema = "reman", joinColumns = @JoinColumn(name = "id_Researcher"), inverseJoinColumns = @JoinColumn(name = "id_Project"))
	private List<Project> projects;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "Publication_Researcher", schema = "reman", joinColumns = @JoinColumn(name = "id_Researcher"), inverseJoinColumns = @JoinColumn(name = "id_Publication"))
	private List<Publication> publications;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "Researcher_ResearchLine", schema = "reman", joinColumns = @JoinColumn(name = "id_Researcher"), inverseJoinColumns = @JoinColumn(name = "id_ResearchLine"))
	private List<ResearchLine> researchLines;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "Researcher_Team", schema = "reman", joinColumns = @JoinColumn(name = "id_Researcher"), inverseJoinColumns = @JoinColumn(name = "id_Team"))
	private List<Team> teams;

	@OneToMany(mappedBy = "researcher", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private List<Title> titles;

	@OneToOne
	@JoinColumn(name = "id_User", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.ALL)
	private User user;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBankData() {
		return bankData;
	}

	public void setBankData(String bankData) {
		this.bankData = bankData;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Association> getAssociations() {
		return associations;
	}

	public void setAssociations(List<Association> associations) {
		this.associations = associations;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
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

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
