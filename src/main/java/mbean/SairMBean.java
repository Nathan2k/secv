package mbean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class SairMBean {

	public String matarSession() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		System.out.println("testechamu");

		//FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		return "/login?faces-redirect=true;";
		
	};

}
//return telas-empresa/temfiltro?faces-redirect=true;
