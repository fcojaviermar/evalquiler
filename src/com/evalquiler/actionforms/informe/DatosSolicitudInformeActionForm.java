package com.evalquiler.actionforms.informe;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class DatosSolicitudInformeActionForm extends ActionForm {

	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosSolicitudInformeActionForm.validate()");
    	ActionErrors errors = null;
        
        return errors;
    }
    

}