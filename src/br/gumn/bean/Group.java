package br.gumn.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "group", schema = "reman")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private String activities;
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "departmentsGroups", schema = "reman", joinColumns = @JoinColumn(name = "group"), inverseJoinColumns = @JoinColumn(name = "department"))
	private List<Department> departments;
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "groupsProjects", schema = "reman", joinColumns = @JoinColumn(name = "group"), inverseJoinColumns = @JoinColumn(name = "project"))
	private List<Project> projects;
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "groupsPublications", schema = "reman", joinColumns = @JoinColumn(name = "group"), inverseJoinColumns = @JoinColumn(name = "publication"))
	private List<Publication> publications;
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "groupsMembers", schema = "reman", joinColumns = @JoinColumn(name = "group"), inverseJoinColumns = @JoinColumn(name = "researcher"))
	private List<Researcher> members;
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "groupsResearchLines", schema = "reman", joinColumns = @JoinColumn(name = "group"), inverseJoinColumns = @JoinColumn(name = "researchLine"))
	private List<ResearchLine> researchLines;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
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
