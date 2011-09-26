package br.gumn.bean;

import java.util.List;

import br.gumn.bean.enumeration.Degree;

public class Researcher {
	private String cpf;
	private String name;
	private String rg;
	private String occupation;
	private String address;
	private String bankData;
	private String lattes;
	private String email;
	private Degree degree;
	private User user;
	private List<Department> departments;
	private List<Group> groups;
	private List<Project> projects;
	private List<Publication> publications;
	private List<ResearchLine> researchLines;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankData() {
		return bankData;
	}

	public void setBankData(String bankData) {
		this.bankData = bankData;
	}

	public String getLattes() {
		return lattes;
	}

	public void setLattes(String lattes) {
		this.lattes = lattes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public List<ResearchLine> getResearchLines() {
		return researchLines;
	}

	public void setResearchLines(List<ResearchLine> researchLines) {
		this.researchLines = researchLines;
	}
}
