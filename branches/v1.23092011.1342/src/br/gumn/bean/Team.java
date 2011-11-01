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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Classe entidade Grupo/Time de Pesquisa.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
@Entity
@Table(name = "Team", schema = "reman")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String description;

	private String name;

	private File plan;

	@ElementCollection
	@CollectionTable(name = "Team_Activities", joinColumns = @JoinColumn(name = "id_Team"))
	@Column(name = "Activity")
	private List<String> activities;

	@ManyToMany(mappedBy = "teams")
	private List<Department> departments;

	@ManyToMany(mappedBy = "teams")
	private List<Project> projects;

	@ManyToMany(mappedBy = "teams")
	private List<Publication> publications;

	@ManyToMany(mappedBy = "teams")
	private List<Researcher> members;

	@ManyToMany(mappedBy = "teams")
	private List<ResearchLine> researchLines;

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
	public List<String> getActivities() {
		return activities;
	}

	/**
	 * @param activities List<String>
	 */
	public void setActivities(List<String> activities) {
		this.activities = activities;
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
}
