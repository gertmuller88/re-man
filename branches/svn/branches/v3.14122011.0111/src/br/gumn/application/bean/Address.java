package br.gumn.application.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe entidade Endereço.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
@Entity
@Table(name = "Address", schema = "reman")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String city;

	private String country;

	private String district;

	private int number;

	private String street;

	private String zipCode;

	@OneToOne(mappedBy = "address", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Department department;

	@OneToOne(mappedBy = "local", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Publication publication;

	@OneToOne(mappedBy = "address", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Researcher researcher;

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
	public String getCity() {
		return city;
	}

	/**
	 * @param city String
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return String
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country String
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return String
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district String
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return Integer
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number Integer
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return String
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street String
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return String
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode String
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
	 * @return Publication
	 */
	public Publication getPublication() {
		return publication;
	}

	/**
	 * @param publication Publication
	 */
	public void setPublication(Publication publication) {
		this.publication = publication;
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
}
