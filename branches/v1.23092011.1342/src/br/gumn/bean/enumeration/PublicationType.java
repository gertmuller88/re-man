package br.gumn.bean.enumeration;

/**
 * Enum respons�vel por listar os tipos de publica��o acad�mica.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public enum PublicationType {
	/**
	 * Artigos publicados em peri�dicos
	 */
	PeriodicArticle(1, "Periodic Article"),

	/**
	 * Artigos publicados em confer�ncias
	 */
	ConferenceArticle(2, "Conference Article"),

	/**
	 * Artigos publicados em workshops
	 */
	WorkshopArticle(3, "Workshop Article"),

	/**
	 * Texto publicado em revistas
	 */
	MagazineText(4, "Magazine/Journal text"),

	/**
	 * Monografia
	 */
	Monography(5, "Monography"),

	/**
	 * Disserta��o
	 */
	Dissertation(6, "Dissertation"),

	/**
	 * Tese
	 */
	Thesis(7, "Thesis"),

	/**
	 * Cap�tulo de Livro
	 */
	Chapter(8, "Book Chapter"),

	/**
	 * Livro
	 */
	Book(9, "Book");

	private final int id;
	private final String type;

	private PublicationType(int id, String type) {
		this.id = id;
		this.type = type;
	}

	/**
	 * M�todo respons�vel pela obten��o do id do valor do Enum.
	 * 
	 * @return Integer
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * M�todo respons�vel pela obten��o da descri��o do valor do Enum.
	 * 
	 * @return String
	 */
	public String getDescription() {
		return this.type;
	}
}
