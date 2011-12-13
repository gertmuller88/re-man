package br.gumn.jsf.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;

/**
 * PhaseListener responsável pelo controle de Requisições.
 * Implementa o padrão PostRedirectGet.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v2.08112011.2240
 */
public class PostRedirectGetListener implements PhaseListener {
	private static final String PRG_DONE_ID = "PostRedirectGetListener.postRedirectGetDone";
	private static final String SAVED_VIEW_ROOT_ID = "PostRedirectGetListener.savedViewRoot";
	private static final String ALL_FACES_MESSAGES_ID = "PostRedirectGetListener.allFacesMessages";
	private static final String ALL_UIINPUT_VALUES_ID = "PostRedirectGetListener.allUIInputValues";

	@Override
	public void afterPhase(PhaseEvent event) {}

	@Override
	public void beforePhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		Map<String, Object> sessionMap = externalContext.getSessionMap();

		if("POST".equals(request.getMethod())) {
			saveViewRoot(facesContext);
			saveFacesMessages(facesContext);
			saveUIInputValues(facesContext);
			redirect(facesContext);
			sessionMap.put(PRG_DONE_ID, true);
		} else if(sessionMap.containsKey(PRG_DONE_ID)) {
			restoreViewRoot(facesContext);
			restoreFacesMessages(facesContext);
			restoreUIInputValues(facesContext);
			sessionMap.remove(PRG_DONE_ID);
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	private static void saveViewRoot(FacesContext facesContext) {
		UIViewRoot savedViewRoot = facesContext.getViewRoot();
		facesContext.getExternalContext().getSessionMap().put(SAVED_VIEW_ROOT_ID, savedViewRoot);
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

	private static void redirect(FacesContext facesContext) {
		String url = facesContext.getApplication().getViewHandler().getActionURL(facesContext, facesContext.getViewRoot().getViewId());

		try {
			facesContext.getExternalContext().redirect(url);
		} catch(IOException e) {
			throw new FacesException("Cannot redirect to " + url + " due to IO exception.", e);
		}
	}

	private static void restoreViewRoot(FacesContext facesContext) {
		UIViewRoot savedViewRoot = (UIViewRoot) facesContext.getExternalContext().getSessionMap().remove(SAVED_VIEW_ROOT_ID);
		facesContext.setViewRoot(savedViewRoot);
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
}
