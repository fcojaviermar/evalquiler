package com.evalquiler.actionforms.usuario;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.combo.ComboTipoDocumento;
import com.evalquiler.combo.ComboTipoUsuario;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.utilidades.Validaciones;
import com.evalquiler.entidad.ElementoComboTipoDocumento;
import com.evalquiler.entidad.ElementoComboTipoUsuario;


public class DatosUsuarioActionForm extends DatosInicioSesionActionForm  {

	private int    idTipoUsuario 	 = 0;
	private String descTipoUsuario 	 = null;
	private String fechaAlta		 = null;
	
	
	public String getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}


	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}


    public String getDescTipoUsuario() {
		return descTipoUsuario;
	}

	public void setDescTipoUsuario(String descTipoUsuario) {
		this.descTipoUsuario = descTipoUsuario;
	}

	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosUsuarioActionForm.validate()");
    	ActionErrors errors = null;
//    	DatosUsuarioActionForm datosUsuario = (DatosUsuarioActionForm)request.getSession().getAttribute("datosUsuarioActionForm");
    	
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
            
            if (Constantes.ELEMENTO_NO_SELECCIONADO == this.getIdTipoUsuario()) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.tipousuario"));
            } else if (!ComboTipoDocumento.elementoValido(this.getIdTipoDocumento())) {
            	errors.add("errorValidacion", new ActionError("error.tipousuario.novalido"));            	
            } else {
            	ComboTipoUsuario combo = new ComboTipoUsuario();
            	ElementoComboTipoUsuario elCombo = combo.get(this.getIdTipoUsuario());
            	this.setDescTipoUsuario(elCombo.getDescripcion());
            }
            
            if ( (null == this.getNifcif()) ||  ("".equals(this.getNifcif()))) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.nifcif"));
            } else if (!documentoValido(this.getIdTipoDocumento(), this.getNifcif())) {
           		errors.add("errorValidacion", new ActionError("error.nifcif.novalido"));
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
            
            if (!this.getAceptarLOPD()) {
            	errors.add("errorValidacion", new ActionError("error.LOPD.no.aceptada"));
            }
    	} else {
    		
    	}
        
        return errors;
    }
    
    private final static boolean documentoValido(final int idTipoDocumento, final String documento) {
    	boolean esValido = false;
    	switch (idTipoDocumento) {
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