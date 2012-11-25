package com.evalquiler.actions.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.entidad.ElementoComboTipoDocumento;
import com.evalquiler.operaciones.OpCliente;

/**
 * @version 	1.0
 * @author
 */
public class GuardarDatosClienteAction extends ActionBase

{

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	System.out.println("GuardarDatosClienteAction.action()");
    	String comandoDestino = ConstantesComandos.EMPTY;
    	DatosClienteActionForm datosCliente = null;
		ActionErrors errors = new ActionErrors();
		ActionMessages messages = new ActionMessages();
		ActionForward forward = new ActionForward(); // return value
		
		try {
			String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
			if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
				datosCliente = (DatosClienteActionForm)request.getSession().getAttribute("datosClienteActionForm");
				datosCliente.setPassword(null);
				datosCliente.setPassword2(null);        	

				request.setAttribute("tipoDocumentoSeleccionado", 
									 new ElementoComboTipoDocumento(String.valueOf(datosCliente.getIdTipoDocumento()), "") );
				request.setAttribute("datosClienteActionForm", datosCliente);
				comandoDestino = ConstantesComandos.CANCEL;
			} else if (ConstantesBotones.GUARDAR.equals(botonPulsado)) {
    			datosCliente = (DatosClienteActionForm)request.getSession().getAttribute("datosClienteActionForm");
    			OpCliente.insertar(datosCliente);
    			
    			messages.add("message", new ActionMessage("msg.cliente.guardado"));
    			this.vaciarSession(request.getSession());
    			comandoDestino = ConstantesComandos.OK;
			} else {
    			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
    			errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
    			comandoDestino = ConstantesComandos.ERROR;    			
    		}    			
		} catch (Exception e) {
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
			comandoDestino = ConstantesComandos.ERROR;			
		}
	
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {
			if (!messages.isEmpty()) {
				saveMessages(request, messages);
			}
		}
	
		forward = mapping.findForward(comandoDestino);
		
		return forward;
    }
    
    
}
