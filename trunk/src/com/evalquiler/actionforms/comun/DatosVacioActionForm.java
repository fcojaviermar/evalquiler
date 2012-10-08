package com.evalquiler.actionforms.comun;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class DatosVacioActionForm extends ActionForm  {


	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosVacioActionForm.validate()");
    	ActionErrors errors = new ActionErrors();
        return errors;
    }

}