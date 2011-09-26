package br.gumn.bean;

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
@Table(name = "researchLine", schema = "reman")
public class ResearchLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String description;
	private String objectives;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "groupsResearchLines", schema = "reman", joinColumns = @JoinColumn(name = "researchLine"), inverseJoinColumns = @JoinColumn(name = "group"))
	private List<Group> groups;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "projectsResearchLines", schema = "reman", joinColumns = @JoinColumn(name = "researchLine"), inverseJoinColumns = @JoinColumn(name = "project"))
	private List<Project> projects;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "publicationsResearchLines", schema = "reman", joinColumns = @JoinColumn(name = "researchLine"), inverseJoinColumns = @JoinColumn(name = "publication"))
	private List<Publication> publications;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "researchersResearchLines", schema = "reman", joinColumns = @JoinColumn(name = "researchLine"), inverseJoinColumns = @JoinColumn(name = "researcher"))
	private List<Researcher> researchers;

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

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
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

	public List<Researcher> getResearchers() {
		return researchers;
	}

	public void setResearchers(List<Researcher> researchers) {
		this.researchers = researchers;
	}
}
