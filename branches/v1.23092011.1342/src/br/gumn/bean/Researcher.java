package br.gumn.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.gumn.bean.enumeration.Degree;

@Entity
@Table(name="researcher", schema="reman")
public class Researcher {
	@Id
	private String cpf;
	private String name;
	private String rg;
	private String occupation;
	private String address;
	private String bankData;
	private String lattes;
	private String email;
	@Enumerated
	private Degree degree;
	@OneToOne
	@JoinColumn(name="user")
	private User user;
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "departmentsMembers", schema = "reman", joinColumns = @JoinColumn(name = "researcher"), inverseJoinColumns = @JoinColumn(name = "department"))
	private List<Department> departments;
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "teamsMembers", schema = "reman", joinColumns = @JoinColumn(name = "researcher"), inverseJoinColumns = @JoinColumn(name = "team"))
	private List<Team> teams;
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "projectsMembers", schema = "reman", joinColumns = @JoinColumn(name = "researcher"), inverseJoinColumns = @JoinColumn(name = "project"))
	private List<Project> projects;
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "publicationsAuthors", schema = "reman", joinColumns = @JoinColumn(name = "researcher"), inverseJoinColumns = @JoinColumn(name = "publication"))
	private List<Publication> publications;
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "researchersResearchLines", schema = "reman", joinColumns = @JoinColumn(name = "researcher"), inverseJoinColumns = @JoinColumn(name = "researchLine"))
	private List<ResearchLine> researchLines;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankData() {
		return bankData;
	}

	public void setBankData(String bankData) {
		this.bankData = bankData;
	}

	public String getLattes() {
		return lattes;
	}

	public void setLattes(String lattes) {
		this.lattes = lattes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
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
}
