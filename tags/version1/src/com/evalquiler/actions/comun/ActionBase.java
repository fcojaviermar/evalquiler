package com.evalquiler.actions.comun;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.comun.constantes.ConstantesComandos;

/**
 * @version 	1.0
 * @author
 */
public abstract class ActionBase extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

		ActionForward forward = null;
        //Aqui va el codigo comun que se ejecuta en todos los Actions antes de llamar al Action especifico.

		try {
			forward = action(mapping, form, request, response);
		} catch (Exception e) {
			forward = mapping.findForward(ConstantesComandos.ERROR);
			ActionErrors errors = (ActionErrors)request.getAttribute("org.apache.struts.action.ERROR");
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
			saveErrors(request, errors);
		}

        //Aqui va el codigo comun que se ejecuta en todos los Actions despues de llamar al Action especifico.

        return forward;

    }

	protected abstract ActionForward action(ActionMapping mapping, ActionForm form,
            								HttpServletRequest request, HttpServletResponse response) throws Exception;

	
    public void vaciarSession(HttpSession session) {
    	Enumeration<String> enume = session.getAttributeNames(); 

    	while (enume.hasMoreElements()) { 
    	    session.removeAttribute(enume.nextElement().toString()); 
    	} 
    }

}
