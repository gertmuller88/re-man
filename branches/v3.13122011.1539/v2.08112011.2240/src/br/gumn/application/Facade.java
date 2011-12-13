package br.gumn.application;

/**
 * Classe responsável por fornecer ligação entre a camada de visualização e de
 * controle, seguindo o padrão MVC.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v1.23092011.1342
 */
public class Facade {
	private static Facade facade;
	
	private Facade() {}
	
	/**
	 * @return Facade
	 */
	public static Facade getInstance() {
		if(facade==null) {
			facade = new Facade();
		}
		return facade;
	}
}
