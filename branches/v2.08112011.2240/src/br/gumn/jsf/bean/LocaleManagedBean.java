package br.gumn.jsf.bean;

import java.util.Locale;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 * ManagedBean responsável pelo controle da internacionalização da aplicação.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v2.08112011.2240
 */
public class LocaleManagedBean {
	private Locale currentLocale = new Locale("pt", "BR");
	
	/**
	 * Método responsável pela linguagem en-US (Inglês Americano).
	 */
	public void englishLocale() {
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		this.currentLocale = Locale.US;
		viewRoot.setLocale(this.currentLocale);
	}
	
	/**
	 * Método responsável pela linguagem pt-BR (Português Brasileiro).
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
