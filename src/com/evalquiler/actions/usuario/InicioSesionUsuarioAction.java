package com.evalquiler.actions.usuario;

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
import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.combo.ComboTipoDocumento;
import com.evalquiler.combo.ComboTipoUsuario;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.entidad.ElementoComboTipoDocumento;
import com.evalquiler.entidad.ElementoComboTipoUsuario;
import com.evalquiler.operaciones.OpRespuestasEncuesta;
import com.evalquiler.operaciones.OpUsuario;

/**
 * @version 	1.0
 * @author
 */
public class InicioSesionUsuarioAction extends ActionBase

{

    public final ActionForward action(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	
    	System.out.println("InicioSesionUsuarioAction.action()");
    	Collection<DatosRealizacionEncuestaActionForm> encuestasRespondidas = null;
    	
    	DatosUsuarioActionForm datosUsuario = null;
    	DatosRealizacionEncuestaActionForm datosRealizacionEncuesta = null;
    	ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		
		try {
			//Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			String botonPulsado = request.getParameter("BOTON_PULSADO");
			
			if (ConstantesBotones.REGISTRARSE.equals(botonPulsado)) {
				//Cargar las combos necesarias para dar de alta un usuario
				request.getSession().setAttribute("tipoDocumento", new ComboTipoDocumento());
				request.getSession().setAttribute("tipoDocumentoSeleccionado", new ElementoComboTipoDocumento("0", "") );				
				request.getSession().setAttribute("tipoUsuario", new ComboTipoUsuario());
				request.getSession().setAttribute("tipoUsuarioSeleccionado", new ElementoComboTipoUsuario("0", "") );
				forward = mapping.findForward("REGISTER_USER");
			} else if (ConstantesBotones.GUARDAR_ENCUESTA.equals(botonPulsado)) {
				datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datoRealizacionEncuestaActionForm");
				encuestasRespondidas = OpRespuestasEncuesta.consultarEncuestasRespondidas(datosRealizacionEncuesta.getDatosUsuario());
				request.setAttribute("encuestasRespondidas", encuestasRespondidas);
				forward = mapping.findForward("POOL_RECOVERY");
			} else {
    			Collection<DatosUsuarioActionForm> listaUsuario = OpUsuario.consultarPorPk(form);
    			
    			if (!listaUsuario.isEmpty()) {
    
    				if (1 == listaUsuario.size()) {
    					Iterator<DatosUsuarioActionForm> iterUsuario = listaUsuario.iterator();
    
    					if (iterUsuario.hasNext()) {
    						datosUsuario = (DatosUsuarioActionForm)iterUsuario.next();  
    						final String pwd = ((DatosInicioSesionActionForm)form).getPassword(); 
    					
    						if (pwd.equals(datosUsuario.getPassword())) {
    							System.out.println("La password es igual.");
    							encuestasRespondidas = OpRespuestasEncuesta.consultarEncuestasRespondidas(datosUsuario);
    							request.setAttribute("encuestasRespondidas", encuestasRespondidas);
    							
    							datosRealizacionEncuesta = new DatosRealizacionEncuestaActionForm();
    							datosRealizacionEncuesta.setDatosUsuario(datosUsuario);
    							request.getSession().setAttribute("datoRealizacionEncuestaActionForm", datosRealizacionEncuesta);
    							
    							forward = mapping.findForward("VALID_USER");
    						} else {
    							System.out.println("La password NO es igual 1.");
    				        	errors.add("errorValidacion", new ActionError("error.distinta.password"));
    							forward = mapping.findForward("NO_EQUAL_PSW");
    						}
    					} else {
    						errors.add("errorValidacion", new ActionError("error.no.existe.usuario"));
    						forward = mapping.findForward("NO_USER");
    					}
    				} else {
    					System.out.println("La password NO es igual 2.");
    					errors.add("errorValidacion", new ActionError("error.mas.de.un.usuario"));
    					forward = mapping.findForward("TWO_EQUAL_USERS");
    				}
    			} else {
    				System.out.println("El usuario no existe.");
    				errors.add("errorValidacion", new ActionError("error.no.existe.usuario"));
    				forward = mapping.findForward("NO_USER");
    			}
			}
		} catch (Exception e) {
			System.out.println("La password usuario NO es igual 4.");
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
