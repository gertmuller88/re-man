package br.gumn.beans.enums;

public enum Degree {
	BSc("Bachelor of Science"), MSc("Master of Science"), DSc(
			"Doctor of Science"), PhD("Doctor of Philosophy"), PostDoc(
			"Post Doctor");

	private final String degree;

	private Degree(String degree) {
		this.degree = degree;
	}

	public String degreeDescription() {
		return this.degree;
	}
}
