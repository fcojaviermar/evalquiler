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

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.combo.ComboTipoDocumento;
import com.evalquiler.entidad.ElementoComboTipoDocumento;
import com.evalquiler.operaciones.OpCliente;

/**
 * @version 	1.0
 * @author
 */
public class InicioSesionClienteAction extends ActionBase

{

    public final ActionForward action(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

    	System.out.println("InicioSesionClienteAction.action()");
    	DatosInicioSesionActionForm cliente = null;    	
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		
		try {
			//Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			String botonPulsado = request.getParameter("BOTON_PULSADO");
			
			if ("Registrarse".equals(botonPulsado)) {
				//Cargar las combos necesarias para dar de alta un usuario
				request.getSession().setAttribute("tipoDocumento", new ComboTipoDocumento());
				request.getSession().setAttribute("tipoDocumentoSeleccionado", new ElementoComboTipoDocumento("0", "") );				
				forward = mapping.findForward("REGISTER_CLIENT");
			} else {
    			Collection<DatosInicioSesionActionForm> listaCliente = OpCliente.consultarPorPk(form);
    			
    			if (!listaCliente.isEmpty()) {
    				if (1 == listaCliente.size()) {
    					Iterator<DatosInicioSesionActionForm> iterUsuario = listaCliente.iterator();
    
    					if (iterUsuario.hasNext()) {
    						cliente = (DatosInicioSesionActionForm)iterUsuario.next();					
    						final String pwd = ((DatosInicioSesionActionForm)form).getPassword(); 
    						
    						if (pwd.equals(cliente.getPassword())) {
    							System.out.println("La password es igual.");
    							forward = mapping.findForward("VALID_CLIENT");
    						} else {
    							System.out.println("La password NO es igual 1.");
    				        	errors.add("errorValidacion", new ActionError("error.distinta.password"));
    							forward = mapping.findForward("NO_EQUAL_PSW");
    						}
    					} else {
    						errors.add("errorValidacion", new ActionError("error.no.existe.cliente"));
    						forward = mapping.findForward("NO_CLIENT");
    					}
    				} else {
    					System.out.println("La password NO es igual 2.");
    					errors.add("errorValidacion", new ActionError("error.mas.de.un.cliente"));
    					forward = mapping.findForward("ERROR_2_EQUAL_CLIENT");
    				}
    			} else {
    				System.out.println("La password NO es igual 3.");
    				errors.add("errorValidacion", new ActionError("error.no.existe.cliente"));				
    				forward = mapping.findForward("NO_CLIENT");
    			}
			}
		} catch (Exception e) {
			System.out.println("La password Cliente NO es igual 4.");
		    // Report the error using the appropriate name and ID.
		    //errors.add("name", new ActionMessage("id"));
		}

		
		// Si se han producido errores se almacenan en la request para que se puedan mostrar por pantalla.
		if (!errors.isEmpty()) {
			System.out.println("Hay errores.");
		    saveErrors(request, errors);
		    System.out.println("Errores guardados.");	
//		    // Forward control to the appropriate 'failure' URI (change name as desired)
//		    forward = mapping.findForward("ERROR");
		} else {
			System.out.println("No hay errores.");
		    // Forward control to the appropriate 'success' URI (change name as desired)
//			request.setAttribute("datosPropietario", (DatosPropietarioActionForm)form);
//		    forward = mapping.findForward("OK");
		}
	
		return forward;
    }
}
