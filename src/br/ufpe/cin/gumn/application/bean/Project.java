package br.ufpe.cin.gumn.application.bean;

import java.io.File;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@ElementCollection
	@CollectionTable(name = "Project_Objectives", joinColumns = @JoinColumn(name = "id_Project"))
	@Column(name = "Objective")
	private List<String> objectives;

	@ManyToMany(mappedBy = "projects")
	private List<Department> departments;

	@ManyToMany
	@JoinTable(name = "Project_Publication", schema = "reman", joinColumns = @JoinColumn(name = "id_Project"), inverseJoinColumns = @JoinColumn(name = "id_Publication"))
	private List<Publication> publications;

	@ManyToMany
	@JoinTable(name = "Project_Researcher", schema = "reman", joinColumns = @JoinColumn(name = "id_Project"), inverseJoinColumns = @JoinColumn(name = "id_Researcher"))
	private List<Researcher> members;

	@ManyToMany
	@JoinTable(name = "Project_ResearchLine", schema = "reman", joinColumns = @JoinColumn(name = "id_Project"), inverseJoinColumns = @JoinColumn(name = "id_ResearchLine"))
	private List<ResearchLine> researchLines;

	@ManyToMany
	@JoinTable(name = "Project_Team", schema = "reman", joinColumns = @JoinColumn(name = "id_Project"), inverseJoinColumns = @JoinColumn(name = "id_Team"))
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
	 * @return List<String>
	 */
	public List<String> getObjectives() {
		return objectives;
	}

	/**
	 * @param objectives List<String>
	 */
	public void setObjectives(List<String> objectives) {
		this.objectives = objectives;
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
