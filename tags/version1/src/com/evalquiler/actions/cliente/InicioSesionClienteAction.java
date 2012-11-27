package com.evalquiler.actions.cliente;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.combo.ComboTipoDocumento;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.entidad.ElementoComboTipoDocumento;
import com.evalquiler.excepciones.cliente.ClienteNoExisteExcepcion;
import com.evalquiler.excepciones.cliente.ClienteRepetidoExcepcion;
import com.evalquiler.operaciones.OpCliente;

/**
 * @version 	1.0
 * @author
 */
public class InicioSesionClienteAction extends ActionBase {

//    public final ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    public final ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {    	
    	System.out.println("InicioSesionClienteAction.action()");
    	String comandoDestino = ConstantesComandos.EMPTY;
    	DatosInicioSesionActionForm cliente = null;    	
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		
		//Aqui va toda la logica del negocio y todas las llamadas a otras clases.
		String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
		
		if (ConstantesBotones.REGISTRARSE.equals(botonPulsado)) {
			//Cargar las combos necesarias para dar de alta un usuario
			request.getSession().setAttribute("tipoDocumento", new ComboTipoDocumento());
			request.getSession().setAttribute("tipoDocumentoSeleccionado", new ElementoComboTipoDocumento() );				
			comandoDestino = ConstantesComandos.REGISTER_CLIENT;
			
		} else if (ConstantesBotones.INICIAR_SESION.equals(botonPulsado)) {
			try { 
    			Collection<DatosClienteActionForm> listaCliente;
				listaCliente = OpCliente.consultarPorPk(form);
    			
 				Iterator<DatosClienteActionForm> iterUsuario = listaCliente.iterator();
				cliente = (DatosClienteActionForm)iterUsuario.next();					
				final String pwd = ((DatosClienteActionForm)form).getPassword(); 
				
				if (pwd.equals(cliente.getPassword())) {
					comandoDestino = ConstantesComandos.VALID_CLIENT;
				} else {
					errors.add("errorValidacion", new ActionError("error.distinta.password"));
		        	comandoDestino = ConstantesComandos.NO_EQUAL_PSW;
		        }
			} catch (ClienteNoExisteExcepcion e) {
				errors.add("errorValidacion", new ActionError(e.getMensaje()));
				comandoDestino = ConstantesComandos.NO_CLIENT;    						
			} catch (ClienteRepetidoExcepcion e) {
				errors.add("errorValidacion", new ActionError(e.getMensaje()));
				comandoDestino = ConstantesComandos.ERROR_2_EQUAL_CLIENTS;    					
			}
		} else {
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
			errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
			comandoDestino = ConstantesComandos.ERROR;    			
		}

		// Si se han producido errores se almacenan en la request para que se puedan mostrar por pantalla.
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {

		}
		forward = mapping.findForward(comandoDestino);
		
		return forward;
    }
}
