package br.gumn.beans.enums;

public enum ResearcherType {
	Professor("Professor"), Advisor("Advisor"), Coordinator("Coordinator"), Student(
			"Student"), Mentee("Mentee");

	private final String type;

	private ResearcherType(String type) {
		this.type = type;
	}

	public String typeDescription() {
		return this.type;
	}
}
