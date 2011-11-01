package br.gumn.bean;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import br.gumn.bean.enumeration.Degree;

/**
 * Classe entidade Título Acadêmico.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
@Entity
@Table(name = "Title", schema = "reman")
public class Title {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String course;

	private Date date;

	@Enumerated(EnumType.STRING)
	private Degree degree;

	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Department", insertable = true, updatable = true)
	private Department department;

	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Researcher", insertable = true, updatable = true)
	private Researcher researcher;

	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Advisor", insertable = true, updatable = true)
	private Researcher advisor;

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
	public String getCourse() {
		return course;
	}

	/**
	 * @param course String
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * @return Date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date Date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return Degree
	 */
	public Degree getDegree() {
		return degree;
	}

	/**
	 * @param degree Degree
	 */
	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	/**
	 * @return Department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department Department
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return Researcher
	 */
	public Researcher getResearcher() {
		return researcher;
	}

	/**
	 * @param researcher Researcher
	 */
	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}

	/**
	 * @return Researcher
	 */
	public Researcher getAdvisor() {
		return advisor;
	}

	/**
	 * @param advisor Researcher
	 */
	public void setAdvisor(Researcher advisor) {
		this.advisor = advisor;
	}
}
