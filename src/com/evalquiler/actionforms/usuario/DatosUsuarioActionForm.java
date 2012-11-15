package com.evalquiler.actionforms.usuario;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.combo.ComboTipoDocumento;
import com.evalquiler.comun.utilidades.Validaciones;
import com.evalquiler.entidad.ElementoComboTipoDocumento;


public class DatosUsuarioActionForm extends DatosInicioSesionActionForm  {

	private String email  			 = null;
	private String nifcif 			 = null;
	private String password2 		 = null;
	private String descTipoDocumento = null;
	private int idTipoDocumento 	 = 0;
	private int idTipoUsuario 	 	 = 0;
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


	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}


	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}


	public String getPassword2() {
		return password2;
	}


	public void setPassword2(String password2) {
		this.password2 = password2;
	}


	public String getDescTipoDocumento() {
		return descTipoDocumento;
	}


	public void setDescTipoDocumento(String descTipoDocumento) {
		this.descTipoDocumento = descTipoDocumento;
	}


	public String getNifcif() {
		return nifcif;
	}


	public void setNifcif(String nifcif) {
		this.nifcif = nifcif;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosUsuarioActionForm.validate()");
    	ActionErrors errors = null;
    	DatosUsuarioActionForm datosUsuario = (DatosUsuarioActionForm)request.getSession().getAttribute("datosUsuarioActionForm");
    	
    	if (null == datosUsuario) {
        	super.validate(mapping, request);
        	
        	errors = new ActionErrors();
            if ( (null == this.getEmail()) ||  ("".equals(this.getEmail()))) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.email"));
            } else if (!Validaciones.emailValido(this.getEmail())) {
            	errors.add("errorValidacion", new ActionError("error.email.novalido"));
            }

            if (0 == this.getIdTipoDocumento()) {        	
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
           		errors.add("errorValidacion", new ActionError("error.nifcif.novalido"));
            }
    
            if ( (null == this.getPassword2()) ||  ("".equals(this.getPassword2()))) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.password2"));
            } else if (!this.getPassword().equals(this.getPassword2())) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.password2"));
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