package br.gumn.bean;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getPlan() {
		return plan;
	}

	public void setPlan(File plan) {
		this.plan = plan;
	}

	public List<String> getObjectives() {
		return objectives;
	}

	public void setObjectives(List<String> objectives) {
		this.objectives = objectives;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public List<Researcher> getMembers() {
		return members;
	}

	public void setMembers(List<Researcher> members) {
		this.members = members;
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
