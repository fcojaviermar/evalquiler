package com.evalquiler.actionforms.vivienda;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.comun.constantes.Constantes;


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
    	System.out.println("DatosBasicosViviendaActionForm.validate()");
    	ActionErrors errors = new ActionErrors();
    	
        if (this.getIdVivienda() <= Constantes.SIN_NUMERICO_EN_VIA){
        	errors.add("errorValidacion", new ActionError("error.obligatorio.idvivienda"));
        } 
        
        return errors;
    }
    

}