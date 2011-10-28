package br.gumn.bean.enumeration;

/**
 * Enum respons�vel por nomear os tipos de usu�rios do sistema.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v1.23092011.1342
 */
public enum UserLevel {
	/**
	 * Administrador
	 */
	Administrator(1, "Administrator"),

	/**
	 * Usu�rio Comum
	 */
	User(2, "User");

	private final int id;
	private final String level;

	private UserLevel(int id, String level) {
		this.id = id;
		this.level = level;
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
		return this.level;
	}
}
