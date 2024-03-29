package com.evalquiler.actionforms.cliente;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.combo.ComboTipoDocumento;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.utilidades.Validaciones;
import com.evalquiler.entidad.ElementoComboTipoDocumento;


public class DatosClienteActionForm extends DatosInicioSesionActionForm  {

	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosClienteActionForm.validate()");
    	ActionErrors errors = null;
    	
    	String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
    	if ( (!ConstantesBotones.CANCELAR.equals(botonPulsado)) &&
             (!ConstantesBotones.GUARDAR.equals(botonPulsado)) ) {
        	super.validate(mapping, request);
        	
        	errors = new ActionErrors();
            if ( (null == this.getEmail()) ||  ("".equals(this.getEmail()))) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.email"));
            } else if (!Validaciones.emailValido(this.getEmail())) {
            	errors.add("errorValidacion", new ActionError("error.email.novalido"));
            }

            if ( (null == this.getEmail2()) ||  ("".equals(this.getEmail2()))) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.email2"));
            } else if (!Validaciones.emailValido(this.getEmail2())) {
            	errors.add("errorValidacion", new ActionError("error.email2.novalido"));
            }               
            
            if (Constantes.ELEMENTO_NO_SELECCIONADO == this.getIdTipoDocumento()) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.tipodocumento"));
            } else if (!ComboTipoDocumento.elementoValido(this.getIdTipoDocumento())) {
            	errors.add("errorValidacion", new ActionError("error.tipodocumento.novalido"));            	
            } else {
            	ComboTipoDocumento combo = new ComboTipoDocumento();
            	ElementoComboTipoDocumento elCombo = combo.get(this.getIdTipoDocumento());
            	this.setDescTipoDocumento(elCombo.getDescripcion());
            }

            if ( (null == this.getNifcif()) ||  ("".equals(this.getNifcif()))) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.nifcif"));
            } else if (!documentoValido(this.getIdTipoDocumento(), this.getNifcif())) {
           		errors.add("errorValidacion", new ActionError("error.documento.novalido"));
            }
    
            if ( (null == this.getPassword2()) ||  ("".equals(this.getPassword2()))) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.password2"));
            } else if (!this.getPassword().equals(this.getPassword2())) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.password2"));
            }
            
        	if (!this.getPassword().equals(this.getPassword2())) {
        		errors.add("errorValidacion", new ActionError("error.passwords.distintas"));
        	}
            	
            if (!this.getEmail().equals(this.getEmail2())) {
            	errors.add("errorValidacion", new ActionError("error.emails.distintos"));
            }

            if (!errors.isEmpty()) {
        		this.setPassword(null);
        		this.setPassword2(null);
        	}
    	} else {
    		
    	}
        
        return errors;
    }

    private final static boolean documentoValido(final int tipoDocumento, final String documento) {
    	boolean esValido = false;
    	switch (tipoDocumento) {
        	case 1: esValido = Validaciones.nifValido(documento);
        			  break;
        	case 2: esValido = Validaciones.nieValido(documento);
        			  break;
        	case 3: esValido = Validaciones.cifValido(documento);
        			  break;
        	default: break;
    	}
    	return esValido;
    }
}