package com.evalquiler.actionforms.comun;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class DatosInicioSesionActionForm extends ActionForm  {

	//static Logger logger = Logger.getLogger(DatosInicioSesionActionForm.class);
	
	private String user = null;
	private String password = null;

	
    public String getUser() {
		return user;
	}

    public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("InformacionUsuarioActionForm.validate()");
//    	DOMConfigurator.configure("log4j.xml");
//        logger.info("Test Log");
//    	logger.debug("Prueba de log");

    	ActionErrors errors = new ActionErrors();
        if ( (null == this.getUser()) ||  ("".equals(this.getUser()))) {
        	errors.add("errorValidacion", new ActionMessage("error.obligatorio.user"));
//        	errors.add("errorValidacion", new ActionError("error.obligatorio.user"));
        }
        if ( (null == this.getPassword()) ||  ("".equals(this.getPassword()))) {
        	errors.add("errorValidacion", new ActionMessage("error.obligatorio.password"));
//        	errors.add("errorValidacion", new ActionError("error.obligatorio.password"));
        }

        return errors;
    }

}