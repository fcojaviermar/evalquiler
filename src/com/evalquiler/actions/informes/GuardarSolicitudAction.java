package com.evalquiler.actions.informes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.informe.SolicitudinformeNoGuardadaExcepcion;
import com.evalquiler.operaciones.OpSolicitudInforme;

/**
 * @version 	1.0
 * @author
 */
public class GuardarSolicitudAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
    		throws ExcepcionEjecutarSentancia, ExcepcionComun {
    	
		System.out.println("GuardarSolicitudAction.action()");
		String comandoDestino = ConstantesComandos.EMPTY;
		ActionErrors errors = new ActionErrors();
		ActionMessages messages = new ActionMessages();
		ActionForward forward = new ActionForward(); // return value

//		long idSolicitud = OpSolicitudInforme.ultimoIdSolicitudInforme();

		try {
			OpSolicitudInforme.insertar(form);
			comandoDestino = ConstantesComandos.OK;
			//messages.add("messages", new ActionMessage("msg.solicitud.informe.guardado", idSolicitud));
			messages.add("messages", new ActionMessage("msg.solicitud.informe.guardado"));			
		} catch (SolicitudinformeNoGuardadaExcepcion e) {
			errors.add("errorExcepcion", new ActionError(e.getMensaje()));
			comandoDestino = ConstantesComandos.NOOK;
		}
	
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {
			if (!messages.isEmpty()) {
			    saveMessages(request, messages);	
			}
		}
	
		forward = mapping.findForward(comandoDestino);
		return (forward);
    }
}
