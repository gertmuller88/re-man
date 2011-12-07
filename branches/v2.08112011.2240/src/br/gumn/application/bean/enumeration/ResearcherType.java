package br.ufpe.cin.gumn.application.bean.enumeration;

/**
 * Enum respons�vel por listar os tipos de pesquisadores.
 * 
 * @author Gert Uch�a M�ller Neto
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
