package br.gumn.bean.enumeration;

/**
 * Enum responsável por nomear os tipos de usuários do sistema.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public enum UserLevel {
	/**
	 * Administrador
	 */
	Administrator(1, "Administrator"),

	/**
	 * Usuário Comum
	 */
	User(2, "User");

	private final int id;
	private final String level;

	private UserLevel(int id, String level) {
		this.id = id;
		this.level = level;
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
		return this.level;
	}
}
