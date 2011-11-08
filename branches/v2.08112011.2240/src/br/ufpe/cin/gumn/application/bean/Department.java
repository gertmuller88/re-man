package br.ufpe.cin.gumn.application.bean;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe entidade Departamento.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
@Entity
@Table(name = "Department", schema = "reman")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String acronym;

	private String name;

	@OneToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Address", insertable = true, updatable = true)
	private Address address;

	@OneToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Link", insertable = true, updatable = true)
	private Link site;

	@ManyToMany
	@JoinTable(name = "Department_Project", schema = "reman", joinColumns = @JoinColumn(name = "id_Department"), inverseJoinColumns = @JoinColumn(name = "id_Project"))
	private List<Project> projects;

	@ManyToMany
	@JoinTable(name = "Department_Publication", schema = "reman", joinColumns = @JoinColumn(name = "id_Department"), inverseJoinColumns = @JoinColumn(name = "id_Publication"))
	private List<Publication> publications;

	@ManyToMany
	@JoinTable(name = "Department_Researcher", schema = "reman", joinColumns = @JoinColumn(name = "id_Department"), inverseJoinColumns = @JoinColumn(name = "id_Researcher"))
	private List<Researcher> members;

	@ManyToMany
	@JoinTable(name = "Department_Team", schema = "reman", joinColumns = @JoinColumn(name = "id_Department"), inverseJoinColumns = @JoinColumn(name = "id_Team"))
	private List<Team> teams;

	@OneToMany(mappedBy = "department")
	private List<Title> titles;

	@ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_University", insertable = true, updatable = true)
	private University university;

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
	 * @return Link
	 */
	public Link getSite() {
		return site;
	}

	/**
	 * @param site Link
	 */
	public void setSite(Link site) {
		this.site = site;
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
	 * @return List<Researcher>
	 */
	public List<Researcher> getMembers() {
		return members;
	}

	/**
	 * @param members List<Researcher>
	 */
	public void setMembers(List<Researcher> members) {
		this.members = members;
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
	 * @return List<title>
	 */
	public List<Title> getTitles() {
		return titles;
	}

	/**
	 * @param titles List<title>
	 */
	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	/**
	 * @return University
	 */
	public University getUniversity() {
		return university;
	}

	/**
	 * @param university University
	 */
	public void setUniversity(University university) {
		this.university = university;
	}
}
