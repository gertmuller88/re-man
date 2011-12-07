package br.ufpe.cin.gumn.application.bean.enumeration;

/**
 * Enum respons�vel por nomear os tipos de graus de forma��o acad�mica.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public enum Degree {
	/**
	 * Bacharel das Ci�ncias
	 */
	BSc(1, "Bachelor of Science"),

	/**
	 * Mestre das Ci�ncias
	 */
	MSc(2, "Master of Science"),

	/**
	 * Doutor das Ci�ncias
	 */
	DSc(3, "Doctor of Science"),

	/**
	 * Doutor em Filosofia
	 */
	PhD(4, "Doctor of Philosophy"),

	/**
	 * P�s-doutor
	 */
	PostDoc(5, "Post Doctor");

	private final int id;
	private final String degree;

	private Degree(int id, String degree) {
		this.id = id;
		this.degree = degree;
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
		return this.degree;
	}
}
