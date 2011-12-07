package br.gumn.jsf.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;
import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.config.mapping.UrlMapping;
import br.gumn.application.bean.User;
import br.gumn.jsf.bean.LoginManagedBean;

/**
 * PhaseListener responsável pelo controle de Autenticação.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v2.08112011.2240
 */
public class AuthenticationListener implements PhaseListener {
	private static final String AUTH_DONE_ID = "AuthenticationListener.redirectDone";
	private static final String ALL_FACES_MESSAGES_ID = "AuthenticationListener.allFacesMessages";
	private static final String ALL_UIINPUT_VALUES_ID = "AuthenticationListener.allUIInputValues";

	@Override
	public void afterPhase(PhaseEvent event) {}

	@Override
	public void beforePhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		
		String requestedPage = facesContext.getViewRoot().getViewId();
		boolean isLoginPage = requestedPage.contains("login.xhtml");
		boolean isBackendPage = this.isBackendPage(requestedPage);
		User user = ((LoginManagedBean) facesContext.getELContext().getELResolver().getValue(facesContext.getELContext(), null, "loginManagedBean")).getUser();
		
		if(sessionMap.containsKey(AUTH_DONE_ID)) {
			restoreFacesMessages(facesContext);
			restoreUIInputValues(facesContext);
			sessionMap.remove(AUTH_DONE_ID);
		} else {
			if(isBackendPage && user==null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você precisa fazer login para utilizar este recurso."));
				saveFacesMessages(facesContext);
				saveUIInputValues(facesContext);
				redirectPretty(facesContext, "login");
				sessionMap.put(AUTH_DONE_ID, true);
			} else if(isLoginPage && user!=null) {
				saveFacesMessages(facesContext);
				saveUIInputValues(facesContext);
				redirectPretty(facesContext, "home");
				sessionMap.put(AUTH_DONE_ID, true);
			}
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	private static void saveFacesMessages(FacesContext facesContext) {
		Map<String, List<FacesMessage>> allFacesMessages = new LinkedHashMap<String, List<FacesMessage>>();
		facesContext.getExternalContext().getSessionMap().put(ALL_FACES_MESSAGES_ID, allFacesMessages);

		Iterator<String> clientIdsWithMessages = facesContext.getClientIdsWithMessages();
		while(clientIdsWithMessages.hasNext()) {
			String clientIdWithMessage = clientIdsWithMessages.next();
			List<FacesMessage> clientFacesMessages = new ArrayList<FacesMessage>();
			allFacesMessages.put(clientIdWithMessage, clientFacesMessages);

			Iterator<FacesMessage> facesMessages = facesContext.getMessages(clientIdWithMessage);
			while(facesMessages.hasNext()) {
				clientFacesMessages.add(facesMessages.next());
			}
		}
	}

	private static void saveUIInputValues(FacesContext facesContext) {
		Map<String, Object> allUIInputValues = new HashMap<String, Object>();
		facesContext.getExternalContext().getSessionMap().put(ALL_UIINPUT_VALUES_ID, allUIInputValues);
		saveUIInputValues(facesContext, facesContext.getViewRoot().getChildren(), allUIInputValues);
	}

	private static void saveUIInputValues(FacesContext facesContext, List<UIComponent> components, Map<String, Object> allUIInputValues) {
		for(UIComponent component : components) {
			if(component instanceof UIInput) {
				UIInput input = (UIInput) component;
				allUIInputValues.put(input.getClientId(facesContext), input.getValue());
			}

			saveUIInputValues(facesContext, component.getChildren(), allUIInputValues);
		}
	}
	
	private static void redirectPretty(FacesContext facesContext, String viewId) {
		PrettyContext context = PrettyContext.getCurrentInstance();
		UrlMapping mapping = context.getConfig().getMappingById(viewId);
		
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		String url = response.encodeRedirectURL(context.getContextPath() + mapping.getPattern());
		try {
			response.sendRedirect(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private static void restoreFacesMessages(FacesContext facesContext) {
		Map<String, List<FacesMessage>> allFacesMessages = (Map<String, List<FacesMessage>>) facesContext.getExternalContext().getSessionMap().remove(ALL_FACES_MESSAGES_ID);

		for(Entry<String, List<FacesMessage>> entry : allFacesMessages.entrySet()) {
			for(FacesMessage clientFacesMessage : entry.getValue()) {
				facesContext.addMessage(entry.getKey(), clientFacesMessage);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static void restoreUIInputValues(FacesContext facesContext) {
		Map<String, Object> allUIInputValues = (Map<String, Object>) facesContext.getExternalContext().getSessionMap().remove(ALL_UIINPUT_VALUES_ID);

		for(Entry<String, Object> entry : allUIInputValues.entrySet()) {
			UIInput input = (UIInput) facesContext.getViewRoot().findComponent(entry.getKey());
			input.setValue(entry.getValue());
		}
	}
	
	private boolean isBackendPage(String page) {
		String backendPages[] = {"home.xhtml", "backendTemplate.xhtml"};
		boolean isBackendPage = false;
		
		for(String backendPage : backendPages) {
			if(page.contains(backendPage)) {
				isBackendPage = true;
				break;
			}
		}
		
		return isBackendPage;
	}
}
