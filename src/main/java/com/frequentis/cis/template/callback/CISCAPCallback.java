package com.frequentis.cis.template.callback;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.frequentis.cis.callback.AppCallback;
import com.frequentis.cis.connector.CISToolConnector;
import com.frequentis.cis.connector.CISToolConnectorImpl;

@Controller("csicapcontroller")
public class CISCAPCallback implements AppCallback {
	
	private Logger log = Logger.getLogger(this.getClass());
	private CISToolConnector connector = new CISToolConnectorImpl();
	
	/**
	 * The constructor registers the Callback on the CIS Connector for retrieving CAP messages.
	 */
	public CISCAPCallback() {
		connector.registerForMsg("CAP", null, this);
	}
	
	
	/**
	 * The implementation of the msgReceived method defined by the AppCallback Interface. The connector calls
	 * this method for sending messages from the CIS to the application.
	 * 
	 */
	public void msgReceived(Object capMsg) {
		log.info("capReceived" + capMsg);

		// forwarding the message to the application REST IF
		RestTemplate restTemplate = new RestTemplate();
	    restTemplate.put("http://localhost:8080/msgReceived", capMsg);
	    
	}
	
	public void msgReceived(String capMsg) {
		log.info("capReceived" + capMsg);
		
	}

}
