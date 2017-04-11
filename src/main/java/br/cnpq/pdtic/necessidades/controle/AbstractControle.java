package br.cnpq.pdtic.necessidades.controle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public abstract class AbstractControle {

	
	
	
    public void addMessageInfo(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  summary);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
    public void addMessageWarn(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary,  summary);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addMessageError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  summary);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
