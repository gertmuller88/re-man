package br.gumn.application.bean;

import java.util.Set;
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
import javax.persistence.OrderBy;
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

	@OneToOne(optional = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Address", insertable = true, updatable = true)
	private Address address;

	@OneToOne(optional = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Link", insertable = true, updatable = true)
	private Link site;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("name")
	@JoinTable(name = "Department_Project", schema = "reman", joinColumns = @JoinColumn(name = "id_Department"), inverseJoinColumns = @JoinColumn(name = "id_Project"))
	private Set<Project> projects;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("date")
	@JoinTable(name = "Department_Publication", schema = "reman", joinColumns = @JoinColumn(name = "id_Department"), inverseJoinColumns = @JoinColumn(name = "id_Publication"))
	private Set<Publication> publications;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("name")
	@JoinTable(name = "Department_Researcher", schema = "reman", joinColumns = @JoinColumn(name = "id_Department"), inverseJoinColumns = @JoinColumn(name = "id_Researcher"))
	private Set<Researcher> members;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("name")
	@JoinTable(name = "Department_Team", schema = "reman", joinColumns = @JoinColumn(name = "id_Department"), inverseJoinColumns = @JoinColumn(name = "id_Team"))
	private Set<Team> teams;

	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("date")
	private Set<Title> titles;

	@ManyToOne(optional = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
	 * @return Set<Researcher>
	 */
	public Set<Researcher> getMembers() {
		return members;
	}

	/**
	 * @param members Set<Researcher>
	 */
	public void setMembers(Set<Researcher> members) {
		this.members = members;
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
	 * @return Set<title>
	 */
	public Set<Title> getTitles() {
		return titles;
	}

	/**
	 * @param titles Set<title>
	 */
	public void setTitles(Set<Title> titles) {
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
