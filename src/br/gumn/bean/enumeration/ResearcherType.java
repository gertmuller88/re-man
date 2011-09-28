package br.gumn.bean.enumeration;

public enum ResearcherType {
	Professor(1, "Professor"),
	Advisor(2, "Advisor"),
	Coordinator(3, "Coordinator"),
	Student(4, "Student"),
	Mentee(5, "Mentee");

	private final int id;
	private final String type;

	private ResearcherType(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public int typeId() {
		return this.id;
	}

	public String typeDescription() {
		return this.type;
	}
}
