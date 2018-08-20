package br.com.redeprimavera.painelnews.model.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesView {

    public static void msgInfo(String titulo, String menssagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, menssagem));
    }

    public static void msgWarn(String titulo, String menssagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, menssagem));
    }

    public static void msgError(String titulo, String menssagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, menssagem));
    }

    public static void msgFatal(String titulo, String menssagem) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, menssagem));
    }
}
