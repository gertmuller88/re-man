package br.gumn.bean.enumeration;

public enum PublicationType {
	PeriodicArticle(1, "Periodic Article"),
	ConferenceArticle(2, "Conference Article"),
	WorkshopArticle(3, "Workshop Article"),
	MagazineText(4, "Magazine/Journal text"),
	Monography(5, "Monography"),
	Dissertation(6, "Dissertation"),
	Thesis(7, "Thesis"),
	Chapter(8, "Book Chapter"),
	Book(9, "Book");

	private final int id;
	private final String type;

	private PublicationType(int id, String type) {
		this.id = id;
		this.type = type;
	}
	
	public int typeID() {
		return this.id;
	}

	public String typeDescription() {
		return this.type;
	}
}
