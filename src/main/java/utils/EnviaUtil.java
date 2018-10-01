package utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import entity.Mensagem;


public class EnviaUtil {

	
	private static final String HOSTNAME = "smtp.gmail.com";
	private static final String USERNAME = "rlemesenai@gmail.com";
	private static final String PASSWORD = "senai2018";
	private static final String EMAILORIGEM = "rlemesenai@gmail.com";
	
	public static Email conectaEmail() throws EmailException{
		   Email email = new SimpleEmail();
		   email.setHostName(HOSTNAME);
		   email.setSmtpPort(587);
		   email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
		   email.setStartTLSEnabled(true);
		   email.setFrom(EMAILORIGEM);
		   
		   return email;
	}
	
	public static void enviaEmail(Mensagem obj) throws EmailException{
		Email email = conectaEmail();
		email.setSubject(obj.getAssunto());
		email.setSubject(obj.getDestinatario());
		email.setContent("<html><body>" + obj.getMensagem() + "<html><body>","text/html");
		email.addTo(obj.getDestinatario());
		email.send();
		
		System.out.println("Enviou");
		FacesContext.getCurrentInstance().addMessage("Para" + obj.getDestinatario(), new FacesMessage("Mensagem enviada"));
	}
	
	
	
	
	
	
	
	
	
	
	
}
