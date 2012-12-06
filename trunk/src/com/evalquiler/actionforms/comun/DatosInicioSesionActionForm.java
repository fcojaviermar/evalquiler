package com.evalquiler.actionforms.comun;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesBotones;


public class DatosInicioSesionActionForm extends ActionForm  {

	private String user 	 		 = null;
	private String password  		 = null;
	private String email  	 		 = null;
	private String email2  	 		 = null;
	private String nifcif 	 		 = null;
	private String password2 		 = null;
	private int idTipoDocumento 	 = 0;
	private String descTipoDocumento = null;
	private boolean aceptarLOPD		 = false;
	private String tipoRol			 = null;
	
	
	public boolean esUsuario() {
		boolean esUsuario = false;
		if (Constantes.USUARIO.equals(this.getTipoRol())) {
			esUsuario = true;
		}
		return esUsuario;
	}

	public boolean esCliente() {
		boolean esCliente = false;
		if (Constantes.CLIENTE.equals(this.getTipoRol())) {
			esCliente = true;
		}
		return esCliente;
	}
	
	public String getTipoRol() {
		return tipoRol;
	}

	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}

	public boolean getAceptarLOPD() {
		return aceptarLOPD;
	}

	public void setAceptarLOPD(boolean aceptarLOPD) {
		this.aceptarLOPD = aceptarLOPD;
	}

	public String getUser() {
		return user;
	}

    public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail2() {
		return email2;
	}


	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	
	public String getPassword2() {
		return password2;
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

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}


	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	

	public String getDescTipoDocumento() {
		return descTipoDocumento;
	}


	public void setDescTipoDocumento(String descTipoDocumento) {
		this.descTipoDocumento = descTipoDocumento;
	}


	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosInicioSesionActionForm.validate()");
    	ActionErrors errors = new ActionErrors();

		String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
		if ( (!ConstantesBotones.REGISTRARSE.equals(botonPulsado)) && 
			 (!ConstantesBotones.GUARDAR_ENCUESTA.equals(botonPulsado)) &&
			 (!ConstantesBotones.CANCELAR.equals(botonPulsado)) && 
			 (!ConstantesBotones.SOLICITAR_INFORME.equals(botonPulsado)) &&
			 (!ConstantesBotones.BUSCAR.equals(botonPulsado)) ) {
            if ( (null == this.getUser()) ||  ("".equals(this.getUser()))) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.user"));
            } else if (this.getUser().length() > Constantes.LONGITUD_USUARIO) {
            	errors.add("errorValidacion", new ActionError("error.usuario.no.valido"));
            }
            if ( (null == this.getPassword()) ||  ("".equals(this.getPassword()))) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.password"));
            } else if (this.getPassword().length() > Constantes.LONGITUD_PASSWORD) {
            	errors.add("errorValidacion", new ActionError("error.password.no.valida"));
            }
		}
		
		if ( (ConstantesBotones.REGISTRARSE.equals(botonPulsado)) || 
			 (ConstantesBotones.INICIAR_SESION.equals(botonPulsado)) ) {
			if (null == this.getTipoRol()) {
				errors.add("errorValidacion", new ActionError("error.obligatorio.tiporol"));
			} else if ( !this.esUsuario() && !this.esCliente()) {
				errors.add("errorValidacion", new ActionError("error.tiporol.no.valido"));
			}
		}
		
        return errors;
    }
    
}