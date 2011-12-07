package br.ufpe.cin.gumn.application.bean.enumeration;

/**
 * Enum responsável por nomear os tipos de graus de formação acadêmica.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public enum Degree {
	/**
	 * Bacharel das Ciências
	 */
	BSc(1, "Bachelor of Science"),

	/**
	 * Mestre das Ciências
	 */
	MSc(2, "Master of Science"),

	/**
	 * Doutor das Ciências
	 */
	DSc(3, "Doctor of Science"),

	/**
	 * Doutor em Filosofia
	 */
	PhD(4, "Doctor of Philosophy"),

	/**
	 * Pós-doutor
	 */
	PostDoc(5, "Post Doctor");

	private final int id;
	private final String degree;

	private Degree(int id, String degree) {
		this.id = id;
		this.degree = degree;
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
		return this.degree;
	}
}
