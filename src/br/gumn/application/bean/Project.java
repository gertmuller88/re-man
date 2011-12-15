package br.gumn.application.bean;

import java.io.File;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * Classe entidade Projeto de Pesquisa.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
@Entity
@Table(name = "Project", schema = "reman")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String description;

	private String name;

	private File plan;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Project_Objectives", joinColumns = @JoinColumn(name = "id_Project"))
	@Column(name = "Objective")
	private Set<String> objectives;

	@ManyToMany(mappedBy = "projects", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("name")
	private Set<Department> departments;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("date")
	@JoinTable(name = "Project_Publication", schema = "reman", joinColumns = @JoinColumn(name = "id_Project"), inverseJoinColumns = @JoinColumn(name = "id_Publication"))
	private Set<Publication> publications;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("name")
	@JoinTable(name = "Project_Researcher", schema = "reman", joinColumns = @JoinColumn(name = "id_Project"), inverseJoinColumns = @JoinColumn(name = "id_Researcher"))
	private Set<Researcher> members;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("title")
	@JoinTable(name = "Project_ResearchLine", schema = "reman", joinColumns = @JoinColumn(name = "id_Project"), inverseJoinColumns = @JoinColumn(name = "id_ResearchLine"))
	private Set<ResearchLine> researchLines;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("name")
	@JoinTable(name = "Project_Team", schema = "reman", joinColumns = @JoinColumn(name = "id_Project"), inverseJoinColumns = @JoinColumn(name = "id_Team"))
	private Set<Team> teams;

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
	 * @return File
	 */
	public File getPlan() {
		return plan;
	}

	/**
	 * @param plan File
	 */
	public void setPlan(File plan) {
		this.plan = plan;
	}

	/**
	 * @return Set<String>
	 */
	public Set<String> getObjectives() {
		return objectives;
	}

	/**
	 * @param objectives Set<String>
	 */
	public void setObjectives(Set<String> objectives) {
		this.objectives = objectives;
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
}
