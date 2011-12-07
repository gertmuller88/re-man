package br.gumn.jsf.bean;

import java.util.Locale;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 * ManagedBean respons�vel pelo controle da internacionaliza��o da aplica��o.
 * 
 * @author Gert Uch�a M�ller Neto
 * @version v2.08112011.2240
 */
public class LocaleManagedBean {
	private Locale currentLocale = new Locale("pt", "BR");
	
	/**
	 * M�todo respons�vel pela linguagem en-US (Ingl�s Americano).
	 */
	public void englishLocale() {
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		this.currentLocale = Locale.US;
		viewRoot.setLocale(this.currentLocale);
	}
	
	/**
	 * M�todo respons�vel pela linguagem pt-BR (Portugu�s Brasileiro).
	 */
	public void portugueseLocale() {
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		this.currentLocale = new Locale("pt", "BR");
		viewRoot.setLocale(this.currentLocale);
	}
	
	/**
	 * @return Locale
	 */
	public Locale getCurrentLocale() {
		return this.currentLocale;
	}
}
