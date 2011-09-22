package br.gumn.beans.enums;

public enum UserLevel {
	Administrator("Administrator"), User("User");

	private final String level;

	private UserLevel(String level) {
		this.level = level;
	}

	public String levelDescription() {
		return this.level;
	}
}
