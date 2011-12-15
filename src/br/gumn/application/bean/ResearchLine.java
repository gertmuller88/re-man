package br.gumn.application.bean;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * Classe entidade Linha de Pesquisa.
 * 
 * @author Gert Uch�a M�ller Neto
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

	@ManyToMany(mappedBy = "researchLines", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("name")
	private Set<Project> projects;

	@ManyToMany(mappedBy = "researchLines", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("date")
	private Set<Publication> publications;

	@ManyToMany(mappedBy = "researchLines", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("name")
	private Set<Researcher> researchers;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("name")
	@JoinTable(name = "ResearchLine_Team", schema = "reman", joinColumns = @JoinColumn(name = "id_ResearchLine"), inverseJoinColumns = @JoinColumn(name = "id_Team"))
	private Set<Team> teams;

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
	public Set<Researcher> getResearchers() {
		return researchers;
	}

	/**
	 * @param researchers Set<Researcher>
	 */
	public void setResearchers(Set<Researcher> researchers) {
		this.researchers = researchers;
	}

	/**
	 * @return Set<Team>
	 */
	public Set<Team> getTeams() {
		return teams;
	}

	/**
	 * @param teams Set<Team>
	 */
	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}
}
