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
import com.evalquiler.operaciones.OpCliente;

/**
 * @version 	1.0
 * @author
 */
public class InicioSesionClienteAction extends ActionBase {

    public final ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	System.out.println("InicioSesionClienteAction.action()");
    	String comandoDestino = ConstantesComandos.EMPTY;
    	DatosInicioSesionActionForm cliente = null;    	
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		
		try {
			//Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
			
			if (ConstantesBotones.REGISTRARSE.equals(botonPulsado)) {
				//Cargar las combos necesarias para dar de alta un usuario
				request.getSession().setAttribute("tipoDocumento", new ComboTipoDocumento());
				request.getSession().setAttribute("tipoDocumentoSeleccionado", new ElementoComboTipoDocumento() );				
				comandoDestino = ConstantesComandos.REGISTER_CLIENT;
			} else {
    			Collection<DatosClienteActionForm> listaCliente = OpCliente.consultarPorPk(form);
    			
    			if (!listaCliente.isEmpty()) {
    				if (1 == listaCliente.size()) {
    					Iterator<DatosClienteActionForm> iterUsuario = listaCliente.iterator();
    
    					if (iterUsuario.hasNext()) {
    						cliente = (DatosClienteActionForm)iterUsuario.next();					
    						final String pwd = ((DatosClienteActionForm)form).getPassword(); 
    						
    						if (pwd.equals(cliente.getPassword())) {
    							comandoDestino = ConstantesComandos.VALID_CLIENT;
    						} else {
    				        	comandoDestino = ConstantesComandos.NO_EQUAL_PSW;
    							errors.add("errorValidacion", new ActionError("error.distinta.password"));
    						}
    					} else {
    						comandoDestino = ConstantesComandos.NO_CLIENT;
    						errors.add("errorValidacion", new ActionError("error.no.existe.cliente"));
    					}
    				} else {
    					comandoDestino = ConstantesComandos.ERROR_2_EQUAL_CLIENTS;
    					errors.add("errorValidacion", new ActionError("error.mas.de.un.cliente"));
    				}
    			} else {
    				comandoDestino = ConstantesComandos.NO_CLIENT;    				
    				errors.add("errorValidacion", new ActionError("error.no.existe.cliente"));
    			}
			}
		} catch (Exception e) {
			comandoDestino = ConstantesComandos.ERROR;
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
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
