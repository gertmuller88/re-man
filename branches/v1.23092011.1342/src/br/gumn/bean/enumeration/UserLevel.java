package br.gumn.bean.enumeration;

public enum UserLevel {
	Administrator(1, "Administrator"),
	User(2, "User");

	private final int id;
	private final String level;

	private UserLevel(int id, String level) {
		this.id = id;
		this.level = level;
	}

	public int levelID() {
		return this.id;
	}

	public String levelDescription() {
		return this.level;
	}
}
