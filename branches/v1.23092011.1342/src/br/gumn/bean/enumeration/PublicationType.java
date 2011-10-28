package br.gumn.bean.enumeration;

/**
 * Enum responsável por listar os tipos de publicação acadêmica.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public enum PublicationType {
	/**
	 * Artigos publicados em periódicos
	 */
	PeriodicArticle(1, "Periodic Article"),

	/**
	 * Artigos publicados em conferências
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
	 * Dissertação
	 */
	Dissertation(6, "Dissertation"),

	/**
	 * Tese
	 */
	Thesis(7, "Thesis"),

	/**
	 * Capítulo de Livro
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
	 * Método responsável pela obtenção do id do valor do Enum.
	 * 
	 * @return Integer
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Método responsável pela obtenção da descrição do valor do Enum.
	 * 
	 * @return String
	 */
	public String getDescription() {
		return this.type;
	}
}
