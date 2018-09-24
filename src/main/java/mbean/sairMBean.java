package mbean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class sairMBean {

	public void matarSession() {
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		System.out.println("testechamu");
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	};
	
	
	
}
