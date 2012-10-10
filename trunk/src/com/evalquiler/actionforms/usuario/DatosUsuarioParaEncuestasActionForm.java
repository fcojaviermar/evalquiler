/**
 * 
 */
package com.evalquiler.actionforms.usuario;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;

/**
 * @author cachorro
 *
 */
public class DatosUsuarioParaEncuestasActionForm extends DatosUsuarioActionForm {

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosUsuarioParaEncuestasActionForm.validate()");
    	ActionErrors errors = null;
    	
    	return errors;
    }
}
