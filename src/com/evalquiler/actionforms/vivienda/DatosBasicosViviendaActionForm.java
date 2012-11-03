package com.evalquiler.actionforms.vivienda;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class DatosBasicosViviendaActionForm extends ActionForm  {

	private long idVivienda = 0;
	
	
	public long getIdVivienda() {
		return idVivienda;
	}


	public void setIdVivienda(long idVivienda) {
		this.idVivienda = idVivienda;
	}




	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosUsuarioActionForm.validate()");
    	ActionErrors errors = null;
    	
    	errors = new ActionErrors();
//        if ( (null == this.getTipoVia()) ||  ("".equals(this.getTipoVia()))) {
//        	errors.add("errorValidacion", new ActionMessage("error.obligatorio.tipovia"));
//        } 
        
        return errors;
    }
    

}