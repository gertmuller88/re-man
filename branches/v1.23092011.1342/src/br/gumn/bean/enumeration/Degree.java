package br.gumn.bean.enumeration;

public enum Degree {
	BSc(1, "Bachelor of Science"),
	MSc(2, "Master of Science"),
	DSc(3, "Doctor of Science"),
	PhD(4, "Doctor of Philosophy"),
	PostDoc(5, "Post Doctor");

	private final int id;
	private final String degree;

	private Degree(int id, String degree) {
		this.id = id;
		this.degree = degree;
	}

	public int degreeID() {
		return this.id;
	}

	public String degreeDescription() {
		return this.degree;
	}
}
