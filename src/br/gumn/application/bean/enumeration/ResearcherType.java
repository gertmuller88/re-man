package br.ufpe.cin.gumn.application.bean.enumeration;

/**
 * Enum responsável por listar os tipos de pesquisadores.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public enum ResearcherType {
	/**
	 * Professor.
	 */
	Professor(1, "Professor"),

	/**
	 * Orientador.
	 */
	Advisor(2, "Advisor"),

	/**
	 * Coordenador.
	 */
	Coordinator(3, "Coordinator"),

	/**
	 * Estudante.
	 */
	Student(4, "Student"),

	/**
	 * Orientando.
	 */
	Mentee(5, "Mentee");

	private final int id;
	private final String type;

	private ResearcherType(int id, String type) {
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
