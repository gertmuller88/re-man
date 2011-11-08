package br.ufpe.cin.gumn.application.bean;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Classe entidade Linha de Pesquisa.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
@Entity
@Table(name = "ResearchLine", schema = "reman")
public class ResearchLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String description;

	private String objectives;

	private String title;

	@ManyToMany(mappedBy = "researchLines")
	private List<Project> projects;

	@ManyToMany(mappedBy = "researchLines")
	private List<Publication> publications;

	@ManyToMany(mappedBy = "researchLines")
	private List<Researcher> researchers;

	@ManyToMany
	@JoinTable(name = "ResearchLine_Team", schema = "reman", joinColumns = @JoinColumn(name = "id_ResearchLine"), inverseJoinColumns = @JoinColumn(name = "id_Team"))
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
	public String getObjectives() {
		return objectives;
	}

	/**
	 * @param objectives String
	 */
	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	/**
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title String
	 */
	public void setTitle(String title) {
		this.title = title;
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
	public List<Researcher> getResearchers() {
		return researchers;
	}

	/**
	 * @param researchers List<Researcher>
	 */
	public void setResearchers(List<Researcher> researchers) {
		this.researchers = researchers;
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
