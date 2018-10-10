package utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensFaces {
	
	public static void m(String s) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(s));
	}
	

}
