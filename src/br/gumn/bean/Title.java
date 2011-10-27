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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Researcher getResearcher() {
		return researcher;
	}

	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}

	public Researcher getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Researcher advisor) {
		this.advisor = advisor;
	}
}
