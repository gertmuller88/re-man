package br.gumn.application;

/**
 * Classe respons�vel por fornecer liga��o entre a camada de visualiza��o e de
 * controle, seguindo o padr�o MVC.
 * 
 * @author Gert Uch�a M�ller Neto
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
