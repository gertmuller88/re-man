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
@Table(name = "ResearchLine", schema = "reman")
public class ResearchLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String description;

	private String objectives;

	private String title;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "Project_ResearchLine", schema = "reman", joinColumns = @JoinColumn(name = "id_ResearchLine"), inverseJoinColumns = @JoinColumn(name = "id_Project"))
	private List<Project> projects;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "Publication_ResearchLine", schema = "reman", joinColumns = @JoinColumn(name = "id_ResearchLine"), inverseJoinColumns = @JoinColumn(name = "id_Publication"))
	private List<Publication> publications;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "Researcher_ResearchLine", schema = "reman", joinColumns = @JoinColumn(name = "id_ResearchLine"), inverseJoinColumns = @JoinColumn(name = "id_Researcher"))
	private List<Researcher> researchers;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "ResearchLine_Team", schema = "reman", joinColumns = @JoinColumn(name = "id_ResearchLine"), inverseJoinColumns = @JoinColumn(name = "id_Team"))
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

	public String getObjectives() {
		return objectives;
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
