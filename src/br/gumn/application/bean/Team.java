package br.gumn.application.bean;

import java.io.File;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
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
	private Set<String> activities;

	@ManyToMany(mappedBy = "teams")
	@OrderBy("name")
	private Set<Department> departments;

	@ManyToMany(mappedBy = "teams")
	@OrderBy("name")
	private Set<Project> projects;

	@ManyToMany(mappedBy = "teams")
	@OrderBy("date")
	private Set<Publication> publications;

	@ManyToMany(mappedBy = "teams")
	@OrderBy("name")
	private Set<Researcher> members;

	@ManyToMany(mappedBy = "teams")
	@OrderBy("title")
	private Set<ResearchLine> researchLines;

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
	public Set<String> getActivities() {
		return activities;
	}

	/**
	 * @param activities Set<String>
	 */
	public void setActivities(Set<String> activities) {
		this.activities = activities;
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
}
