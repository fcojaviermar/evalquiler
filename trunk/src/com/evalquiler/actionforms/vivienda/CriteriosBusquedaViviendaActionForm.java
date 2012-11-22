package com.evalquiler.actionforms.vivienda;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.comun.constantes.Constantes;


public final class CriteriosBusquedaViviendaActionForm extends ActionForm  {

	private int idTipoVia		   = 0;
	private String nombreVia	   = null;
	private int numeroVia	  	   = 0;
	private String bloque		   = null;
	private int portal			   = 0;
	private String escalera		   = null;
	private int planta			   = 0;
	private String puerta		   = null;
	private int codigoPostal	   = 0;
	private int municipio		   = 0;
	private int provincia		   = 0;
	private int pais			   = 0;
	private String nifPropietario  = null;

	
	public final int getIdTipoVia() {
		return idTipoVia;
	}


	public final void setIdTipoVia(int idTipoVia) {
		this.idTipoVia = idTipoVia;
	}

	public final boolean tieneIdTipoVia() {
		boolean tieneInfo = false;
		if (Constantes.ELEMENTO_NO_SELECCIONADO < this.getIdTipoVia()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}
	
	public final String getNombreVia() {
		return nombreVia;
	}

	public final String getNombreViaLike() {
		return "%".concat(nombreVia.concat("%")) ;
	}
	
	public final boolean tieneInfoNombreVia() {
		boolean tieneInfo = false;
		if ( (null != this.getNombreVia()) && (!"".equals(this.getNombreVia())) ) {
			tieneInfo = true;
		}
		return tieneInfo;
	}
	
	public final void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}


	public final int getNumeroVia() {
		return numeroVia;
	}

	public final boolean tieneNumeroVia() {
		boolean tieneInfo = false;
		if (Constantes.SIN_NUMERICO_EN_VIA <= this.getNumeroVia()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}


	public final void setNumeroVia(int numeroVia) {
		this.numeroVia = numeroVia;
	}


	public final String getBloque() {
		return bloque;
	}

	public final String getBloqueLike() {
		return "%".concat(bloque.concat("%")) ;
	}

	public final boolean tieneBloque() {
		boolean tieneInfo = false;
		if ( (null != this.getBloque()) && (!"".equals(this.getBloque())) ) {
			tieneInfo = true;
		}
		return tieneInfo;
	}	

	public final void setBloque(String bloque) {
		this.bloque = bloque;
	}


	public final int getPortal() {
		return portal;
	}

	public final boolean tienePortal() {
		boolean tieneInfo = false;
		if (Constantes.SIN_NUMERICO_EN_VIA <= this.getPortal()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}
	
	public final void setPortal(int portal) {
		this.portal = portal;
	}


	public final String getEscalera() {
		return escalera;
	}
	
	public final String getEscaleraLike() {
		return "%".concat(escalera.concat("%")) ;
	}
	
	
	public final boolean tieneEscalera() {
		boolean tieneInfo = false;
		if ( (null != this.getEscalera()) && (!"".equals(this.getEscalera())) ) {
			tieneInfo = true;
		}
		return tieneInfo;
	}

	public final void setEscalera(String escalera) {
		this.escalera = escalera;
	}


	public final int getPlanta() {
		return planta;
	}

	public final boolean tienePlanta() {
		boolean tieneInfo = false;
		if (Constantes.SIN_NUMERICO_EN_VIA <= this.getPlanta()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}

	public final void setPlanta(int planta) {
		this.planta = planta;
	}


	public final String getPuerta() {
		return puerta;
	}

	public final String getPuertaLike() {
		return "%".concat(puerta.concat("%")) ;
	}
	
	public final boolean tienePuerta() {
		boolean tieneInfo = false;
		if ( (null != this.getPuerta()) && (!"".equals(this.getPuerta())) ) {
			tieneInfo = true;
		}
		return tieneInfo;
	}

	public final void setPuerta(String puerta) {
		this.puerta = puerta;
	}


	public final int getCodigoPostal() {
		return codigoPostal;
	}

	public final boolean tieneCodigoPostal() {
		boolean tieneInfo = false;
		if (Constantes.SIN_NUMERICO_EN_VIA < this.getCodigoPostal()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}

	public final void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public final int getMunicipio() {
		return municipio;
	}

	public final boolean tieneMunicipio() {
		boolean tieneInfo = false;
		if (Constantes.ELEMENTO_NO_SELECCIONADO < this.getMunicipio()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}

	public final void setMunicipio(int municipio) {
		this.municipio = municipio;
	}


	public final int getProvincia() {
		return provincia;
	}

	public final boolean tieneProvincia() {
		boolean tieneInfo = false;
		if (Constantes.ELEMENTO_NO_SELECCIONADO < this.getProvincia()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}

	public final void setProvincia(int provincia) {
		this.provincia = provincia;
	}


	public final int getPais() {
		return pais;
	}

	public final boolean tienePais() {
		boolean tieneInfo = false;
		if (Constantes.ELEMENTO_NO_SELECCIONADO < this.getPais()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}

	public final void setPais(int pais) {
		this.pais = pais;
	}


	public final String getNifPropietario() {
		return nifPropietario;
	}

	public final String getNifPropietarioLike() {
		return "%".concat(nifPropietario.concat("%")) ;
	}
	
	public final boolean tieneNifPropietario() {
		boolean tieneInfo = false;
		if ( (null != this.getNifPropietario()) && (!"".equals(this.getNifPropietario())) ) {
			tieneInfo = true;
		}
		return tieneInfo;
	}

	public final void setNifPropietario(String nifPropietario) {
		this.nifPropietario = nifPropietario;
	}

	

	/*
     * Validamamos los datos introducidos por el usuario
     */
    public final ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosUsuarioActionForm.validate()");
    	ActionErrors errors = null;
    	
    	errors = new ActionErrors();
//        if ( (null == this.getTipoVia()) ||  ("".equals(this.getTipoVia()))) {
//        	errors.add("errorValidacion", new ActionMessage("error.obligatorio.tipovia"));
//        } 
        
        return errors;
    }
    

}