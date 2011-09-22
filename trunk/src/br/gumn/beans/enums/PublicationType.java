package br.gumn.beans.enums;

public enum PublicationType {
	PeriodicArticle("Periodic Article"), ConferenceArticle("Conference Article"), WorkshopArticle(
			"Workshop Article"), MagazineText("Magazine/Journal text"), Monography(
			"Monography"), Dissertation("Dissertation"), Thesis("Thesis"), Chapter(
			"Book Chapter"), Book("Book");

	private final String type;

	private PublicationType(String type) {
		this.type = type;
	}

	public String typeDescription() {
		return this.type;
	}
}
