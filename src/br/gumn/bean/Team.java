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

	public List<String> getActivities() {
		return activities;
	}

	public void setActivities(List<String> activities) {
		this.activities = activities;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
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
}
