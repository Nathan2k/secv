package mbean;

import org.apache.commons.mail.EmailException;

import entity.Mensagem;
import utils.EnviaUtil;

public class EmailMBean {

	
	
private Mensagem msgClass;
	
	public EmailMBean() {
		msgClass = new Mensagem();
	}
	
	public void enviar(){
		try {
			EnviaUtil.enviaEmail(msgClass);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Mensagem getMsgClass() {
		return msgClass;
	}

	public void setMsgClass(Mensagem msgClass) {
		this.msgClass = msgClass;
	}
	
	
	
	
}
