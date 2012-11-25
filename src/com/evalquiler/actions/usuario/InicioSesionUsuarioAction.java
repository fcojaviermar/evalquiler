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
import com.evalquiler.comun.constantes.ConstantesComandos;
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

    public final ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	System.out.println("InicioSesionUsuarioAction.action()");
    	Collection<DatosRealizacionEncuestaActionForm> encuestasRespondidas = null;
    	String comandoDestino = ConstantesComandos.EMPTY;
    	DatosUsuarioActionForm datosUsuario = null;
    	DatosRealizacionEncuestaActionForm datosRealizacionEncuesta = null;
    	ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		
		try {
			//Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
			
			if (ConstantesBotones.REGISTRARSE.equals(botonPulsado)) {
				comandoDestino = ConstantesComandos.REGISTER_USER;
				//Cargar las combos necesarias para dar de alta un usuario
				request.getSession().setAttribute("tipoDocumento", new ComboTipoDocumento());
				request.getSession().setAttribute("tipoUsuario", new ComboTipoUsuario());
				request.getSession().setAttribute("tipoDocumentoSeleccionado", new ElementoComboTipoDocumento() );
				request.getSession().setAttribute("tipoUsuarioSeleccionado", new ElementoComboTipoUsuario() );

			} else if (ConstantesBotones.GUARDAR_ENCUESTA.equals(botonPulsado)) {
				comandoDestino = ConstantesComandos.POOL_RECOVERY;				
				datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
				encuestasRespondidas = OpRespuestasEncuesta.consultarEncuestasRespondidas(datosRealizacionEncuesta.getDatosUsuario());
				request.setAttribute("encuestasRespondidas", encuestasRespondidas);
			} else {
    			Collection<DatosUsuarioActionForm> listaUsuario = OpUsuario.consultarPorPk(form);
    			if (!listaUsuario.isEmpty()) {
    
    				if (1 == listaUsuario.size()) {
    					Iterator<DatosUsuarioActionForm> iterUsuario = listaUsuario.iterator();
    
    					if (iterUsuario.hasNext()) {
    						datosUsuario = (DatosUsuarioActionForm)iterUsuario.next();  
    						final String pwd = ((DatosInicioSesionActionForm)form).getPassword(); 
    					
    						if (pwd.equals(datosUsuario.getPassword())) {
    							datosRealizacionEncuesta = new DatosRealizacionEncuestaActionForm();    							
    							datosRealizacionEncuesta.setDatosUsuario(datosUsuario);
    							
    							encuestasRespondidas = OpRespuestasEncuesta.consultarEncuestasRespondidas(datosUsuario);
    							comandoDestino = ConstantesComandos.VALID_USER;
    							
    							request.setAttribute("encuestasRespondidas", encuestasRespondidas);    							
    							request.getSession().setAttribute("datosRealizacionEncuestaActionForm", datosRealizacionEncuesta);    							
    						} else {
    							comandoDestino = ConstantesComandos.NO_EQUAL_PSW;
    							errors.add("errorValidacion", new ActionError("error.distinta.password"));
    						}
    					} else {
    						comandoDestino = ConstantesComandos.NO_USER;
    						errors.add("errorValidacion", new ActionError("error.no.existe.usuario"));
    					}
    				} else {
    					comandoDestino = ConstantesComandos.TWO_EQUAL_USERS;
    					errors.add("errorValidacion", new ActionError("error.mas.de.un.usuario"));
    				}
    			} else {
    				comandoDestino = ConstantesComandos.NO_USER;
    				errors.add("errorValidacion", new ActionError("error.no.existe.usuario"));    				
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
