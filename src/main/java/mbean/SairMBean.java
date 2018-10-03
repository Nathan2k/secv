package mbean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
public class SairMBean {

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
