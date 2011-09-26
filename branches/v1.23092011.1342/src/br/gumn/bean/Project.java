package br.gumn.bean;

import java.io.File;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project", schema = "reman")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String description;
	private String objectives;
	private File document;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "departmentsProjects", schema = "reman", joinColumns = @JoinColumn(name = "project"), inverseJoinColumns = @JoinColumn(name = "department"))
	private List<Department> departments;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "groupsProjects", schema = "reman", joinColumns = @JoinColumn(name = "project"), inverseJoinColumns = @JoinColumn(name = "group"))
	private List<Group> groups;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "projectsPublications", schema = "reman", joinColumns = @JoinColumn(name = "project"), inverseJoinColumns = @JoinColumn(name = "publication"))
	private List<Publication> publications;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "projectsMembers", schema = "reman", joinColumns = @JoinColumn(name = "project"), inverseJoinColumns = @JoinColumn(name = "researcher"))
	private List<Researcher> members;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "projectsResearchLines", schema = "reman", joinColumns = @JoinColumn(name = "project"), inverseJoinColumns = @JoinColumn(name = "researchLine"))
	private List<ResearchLine> researchLines;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getObjectives() {
		return objectives;
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	public File getDocument() {
		return document;
	}

	public void setDocument(File document) {
		this.document = document;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
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
