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

import com.evalquiler.combo.ComboProvincia;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.operaciones.OpProvincia;

/**
 * @version 	1.0
 * @author
 */
public abstract class ActionBase extends Action {

	public static ComboProvincia comboProvincia = null;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward = null;
		
        //Aqui va el codigo comun que se ejecuta en todos los Actions despues de llamar al Action especifico.
		if (request.isRequestedSessionIdValid()) { 
			try {
				if (null == comboProvincia) {
					comboProvincia = OpProvincia.obtenerProvincias();
				}

				forward = action(mapping, form, request, response);
			} catch (ExcepcionEjecutarSentancia e) {
				ActionErrors errors = (ActionErrors)request.getAttribute("org.apache.struts.action.ERROR");
				errors.add("errorExcepcion", new ActionError("error.global.mesage"));
				saveErrors(request, errors);
				forward = mapping.findForward(ConstantesComandos.ERROR);				
			} catch (ExcepcionComun e) {
				ActionErrors errors = (ActionErrors)request.getAttribute("org.apache.struts.action.ERROR");
				errors.add("errorExcepcion", new ActionError(e.getMensaje()));
				saveErrors(request, errors);
				forward = mapping.findForward(ConstantesComandos.ERROR);				
			} catch (Exception e) {
				ActionErrors errors = (ActionErrors)request.getAttribute("org.apache.struts.action.ERROR");
				errors.add("errorExcepcion", new ActionError("error.global.mesage"));
				saveErrors(request, errors);
				forward = mapping.findForward(ConstantesComandos.ERROR);				
			}
		} else { 
			forward = mapping.findForward(ConstantesComandos.ERROR);
			ActionErrors errors = new ActionErrors();
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
			saveErrors(request, errors);
		}

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
