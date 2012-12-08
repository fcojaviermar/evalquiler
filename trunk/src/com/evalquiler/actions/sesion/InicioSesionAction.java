package com.evalquiler.actions.sesion;

import java.util.Collection;
import java.util.Iterator;

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
import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.combo.ComboMunicipio;
import com.evalquiler.combo.ComboTipoDocumento;
import com.evalquiler.combo.ComboTipoUsuario;
import com.evalquiler.combo.ComboTipoVia;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.comun.utilidades.UtilidadesFicheros;
import com.evalquiler.entidad.ElementoComboMunicipio;
import com.evalquiler.entidad.ElementoComboProvincia;
import com.evalquiler.entidad.ElementoComboTipoDocumento;
import com.evalquiler.entidad.ElementoComboTipoUsuario;
import com.evalquiler.entidad.ElementoComboTipoVia;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.cliente.ClienteNoExisteExcepcion;
import com.evalquiler.excepciones.cliente.ClienteRepetidoExcepcion;
import com.evalquiler.excepciones.usuario.UsuarioNoExisteExcepcion;
import com.evalquiler.excepciones.usuario.UsuarioRepetidoExcepcion;
import com.evalquiler.operaciones.OpCliente;
import com.evalquiler.operaciones.OpRespuestasEncuesta;
import com.evalquiler.operaciones.OpUsuario;

public class InicioSesionAction extends ActionBase {
	
    public final ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
    		throws ExcepcionEjecutarSentancia {
    	
		System.out.println("InicioSesionAction.action()");
		Collection<DatosRealizacionEncuestaActionForm> encuestasRespondidas = null;
		Collection<DatosClienteActionForm> 			   listaCliente 		= null;
		
		DatosRealizacionEncuestaActionForm datosRealizacionEncuesta = null;
		DatosUsuarioActionForm 			   datosUsuario 			= null;
		DatosInicioSesionActionForm 	   cliente 				    = null;
		
		ActionMessages messages = new ActionMessages();
		ActionErrors   errors   = new ActionErrors();
		ActionForward  forward  = new ActionForward(); 
		String comandoDestino   = ConstantesComandos.EMPTY;
		
		String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
		if (ConstantesBotones.REGISTRARSE.equals(botonPulsado)) {
			request.getSession().setAttribute("tipoDocumento", new ComboTipoDocumento());
			request.getSession().setAttribute("tipoDocumentoSeleccionado", new ElementoComboTipoDocumento() );				
			if (((DatosInicioSesionActionForm)form).esUsuario() ) {
				request.getSession().setAttribute("tipoUsuario", new ComboTipoUsuario());
				request.getSession().setAttribute("tipoUsuarioSeleccionado", new ElementoComboTipoUsuario() );
				comandoDestino = ConstantesComandos.REGISTER_USER;
			} else if (((DatosInicioSesionActionForm)form).esCliente() ) {
				comandoDestino = ConstantesComandos.REGISTER_CLIENT;
			} else {
				
			}
			
		} else if (ConstantesBotones.GUARDAR_ENCUESTA.equals(botonPulsado)) {
			datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
			encuestasRespondidas = OpRespuestasEncuesta.consultarEncuestasRespondidas(datosRealizacionEncuesta.getDatosUsuario());
			request.setAttribute("encuestasRespondidas", encuestasRespondidas);
			comandoDestino = ConstantesComandos.POOL_RECOVERY;
			
		} else if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
			datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
			encuestasRespondidas = OpRespuestasEncuesta.consultarEncuestasRespondidas(datosRealizacionEncuesta.getDatosUsuario());
			request.setAttribute("encuestasRespondidas", encuestasRespondidas);
			comandoDestino = ConstantesComandos.POOL_RECOVERY;
			
		} else if (ConstantesBotones.INICIAR_SESION.equals(botonPulsado)) {
			if (((DatosInicioSesionActionForm)form).esUsuario() ) {
				Collection<DatosUsuarioActionForm> listaUsuario = null;
				try {
					listaUsuario = OpUsuario.consultarPorPk(form);
					Iterator<DatosUsuarioActionForm> iterUsuario = listaUsuario.iterator();
					datosUsuario = (DatosUsuarioActionForm)iterUsuario.next();
					UtilidadesFicheros.escribir("Tipousuario: " + datosUsuario.getIdTipoUsuario());
					final String pwd = ((DatosInicioSesionActionForm)form).getPassword(); 
				
					if (pwd.equals(datosUsuario.getPassword())) {
						datosRealizacionEncuesta = new DatosRealizacionEncuestaActionForm();    							
						datosRealizacionEncuesta.setDatosUsuario(datosUsuario);
						
						encuestasRespondidas = OpRespuestasEncuesta.consultarEncuestasRespondidas(datosUsuario);
						request.setAttribute("encuestasRespondidas", encuestasRespondidas);    							
						request.getSession().setAttribute("datosRealizacionEncuestaActionForm", datosRealizacionEncuesta);
						comandoDestino = ConstantesComandos.VALID_USER;
						
					} else {
						errors.add("errorValidacion", new ActionError("error.distinta.password"));
						comandoDestino = ConstantesComandos.NO_EQUAL_PSW;
						
					}
				} catch (UsuarioNoExisteExcepcion e) {
					errors.add("errorValidacion", new ActionError("error.no.existe.usuario"));    				
					comandoDestino = ConstantesComandos.NO_USER;
				} catch (UsuarioRepetidoExcepcion e) {
					errors.add("errorValidacion", new ActionError("error.mas.de.un.usuario"));
					comandoDestino = ConstantesComandos.TWO_EQUAL_USERS;
				}
			} else if (((DatosInicioSesionActionForm)form).esCliente() ) {
				try { 
					listaCliente = OpCliente.consultarPorPk(form);
	    			
	 				Iterator<DatosClienteActionForm> iterUsuario = listaCliente.iterator();
					cliente = (DatosClienteActionForm)iterUsuario.next();					
					final String pwd = ((DatosInicioSesionActionForm)form).getPassword(); 
					
					if (pwd.equals(cliente.getPassword())) {
						request.getSession().setAttribute("datosClienteActionForm", cliente);
						request.getSession().setAttribute("tipoVia", new ComboTipoVia());
						request.getSession().setAttribute("tipoViaSeleccionado", new ElementoComboTipoVia());
						request.getSession().setAttribute("comboProvincia", comboProvincia);
						request.setAttribute("elementoProvincia", new ElementoComboProvincia());
						request.setAttribute("comboMunicipio", new ComboMunicipio());
						request.setAttribute("elementoMunicipio", new ElementoComboMunicipio());
						messages.add("message", new ActionMessage("msg.solicitud.operacion.previa"));
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
				
			}
		} else if (ConstantesBotones.SOLICITAR_INFORME.equals(botonPulsado)) {
			request.setAttribute("elementoProvincia", new ElementoComboProvincia());
			request.setAttribute("comboMunicipio", new ComboMunicipio());
			request.setAttribute("elementoMunicipio", new ElementoComboMunicipio());
			comandoDestino = ConstantesComandos.VALID_CLIENT;

		} else if (ConstantesBotones.BUSCAR.equals(botonPulsado)) {
			request.setAttribute("elementoProvincia", new ElementoComboProvincia());
			request.setAttribute("comboMunicipio", new ComboMunicipio());
			request.setAttribute("elementoMunicipio", new ElementoComboMunicipio());
			comandoDestino = ConstantesComandos.VALID_CLIENT;
			
		} else {
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
			errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
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
