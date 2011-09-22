package br.gumn.beans;

import java.io.File;
import java.util.Date;
import java.util.List;
import br.gumn.beans.enums.PublicationType;

public class Publication {
	private int id;
	private String title;
	private Date date;
	private int edition;
	private String publishingHouse;
	private String brief;
	private String proceeding;
	private String city;
	private File pdf;
	private File bibtex;
	private PublicationType type;
	private List<Researcher> authors;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getProceeding() {
		return proceeding;
	}

	public void setProceeding(String proceeding) {
		this.proceeding = proceeding;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public File getPdf() {
		return pdf;
	}

	public void setPdf(File pdf) {
		this.pdf = pdf;
	}

	public File getBibtex() {
		return bibtex;
	}

	public void setBibtex(File bibtex) {
		this.bibtex = bibtex;
	}

	public PublicationType getType() {
		return type;
	}

	public void setType(PublicationType type) {
		this.type = type;
	}

	public List<Researcher> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Researcher> authors) {
		this.authors = authors;
	}

	public List<ResearchLine> getResearchLines() {
		return researchLines;
	}

	public void setResearchLines(List<ResearchLine> researchLines) {
		this.researchLines = researchLines;
	}
}
