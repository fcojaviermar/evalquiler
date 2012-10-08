package com.evalquiler.actionforms.vivienda;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;


public class ResultadosBusquedaViviendaActionForm extends DatosInicioSesionActionForm  {


	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("ResultadosBusquedaViviendaActionForm.validate()");
    	ActionErrors errors = null;

       
        return errors;
    }
    
}