package com.evalquiler.actions.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.operaciones.OpUsuario;

/**
 * @version 	1.0
 * @author
 */
public class GuardarDatosUsuarioAction extends ActionBase

{

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	System.out.println("GuardarDatosUsuarioAction.action()");
    	DatosUsuarioActionForm datosUsuario = null;
    	String comandoDestino = ConstantesComandos.ERROR;
    	ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		
		try {
		    // Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			//Guardar los datos del usuario en base de datos y enviar mail.
			datosUsuario = (DatosUsuarioActionForm)request.getSession().getAttribute("datosUsuarioActionForm");
			OpUsuario.insertar(datosUsuario);
			comandoDestino = ConstantesComandos.OK;
			//Se elimina de la sesión porque el usuario se ha dado de alta correctamente y se finaliza este servicio.
			request.getSession().setAttribute("datosUsuarioActionForm", null);
		} catch (Exception e) {
			comandoDestino = ConstantesComandos.ERROR;
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
		}
	
		// If a message is required, save the specified key(s)
		// into the request for use by the <struts:errors> tag.
	
		forward = mapping.findForward(comandoDestino);
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {
			
		}
	
		forward = mapping.findForward(comandoDestino);
		return (forward);
    }
}