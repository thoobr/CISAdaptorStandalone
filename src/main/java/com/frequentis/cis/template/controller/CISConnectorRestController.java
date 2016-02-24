package com.frequentis.cis.template.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frequentis.cis.connector.CISToolConnector;
import com.frequentis.cis.connector.CISToolConnectorImpl;
import com.frequentis.cis.connector.edxlde.EDXLDEParameters;
import com.frequentis.cis.core.edxlde.parameters.DEParameters;
import com.frequentis.cis.template.response.NotifyResponse;

/**
 * The RestControler that exposes the Connector if as REST Endpoint.
 * 
 * @author TObritzh
 * @version 1.0
 *
 */
@RestController
public class CISConnectorRestController {
	
	private CISToolConnector connector = new CISToolConnectorImpl();
	
	/**
	 * The Connector Rest Endpoint to distribute messages from the application via the CIS to other applications.
	 *  
	 * @param msgType The type of the message (e.g.: CAP, EMIS, WMS/WFS)
	 * @param msg The String representation of the message (e.g.: CAL XML)
	 * @param deParameters The EDXL DE parameters that should be filled in the EDXL DE envelope
	 * @return notifyResponse Object that contains detailed information about the execution status
	 */
	@RequestMapping("/notify")
    public NotifyResponse notify(@RequestParam(value="msgType") String msgType,
    		@RequestParam(value="msg") String msg,
    		@RequestParam(value="deParameters", required=false) Map<DEParameters, String> deParameters) {
		
		try {
			connector.notify(msgType, msg, deParameters);
		} catch (Exception e) {
			return new NotifyResponse("Error", "The message was not sent!", e.getMessage());
		}
        return new NotifyResponse("SUCCESS", "The message was successfully sent!");
    }

}
