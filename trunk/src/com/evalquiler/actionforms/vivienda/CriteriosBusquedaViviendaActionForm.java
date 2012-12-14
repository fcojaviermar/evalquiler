package com.evalquiler.actionforms.vivienda;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.combo.ComboMunicipio;
import com.evalquiler.combo.ComboProvincia;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.entidad.ElementoComboMunicipio;
import com.evalquiler.entidad.ElementoComboProvincia;


public class CriteriosBusquedaViviendaActionForm extends ActionForm  {

	private int idTipoVia		   = 0;
	private String nombreVia	   = null;
	private Integer numeroVia	   = null;
	private String bloque		   = null;
	private Integer portal		   = null;
	private String escalera		   = null;
	private Integer planta		   = null;;
	private String puerta		   = null;
	private Integer codigoPostal   = null;
	private String idMunicipio	   = null;
	private String idProvincia	   = null;
	private int pais			   = 34;
	private String nifPropietario  = null;
	
	
	
	public String getIdMunicipio() {
		return idMunicipio;
	}


	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}


	public String getIdProvincia() {
		return idProvincia;
	}


	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}


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


	public final Integer getNumeroVia() {
		return numeroVia;
	}

	public final boolean tieneNumeroVia() {
		boolean tieneInfo = false;
		if (null != this.getNumeroVia()) {
			tieneInfo = true;
		}
		return tieneInfo;

	}


	public final void setNumeroVia(Integer numeroVia) {
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


	public final Integer getPortal() {
		return portal;
	}

	public final boolean tienePortal() {
		boolean tieneInfo = false;
		if (null != this.getPortal()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}
	
	public final void setPortal(Integer portal) {
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


	public final Integer getPlanta() {
		return planta;
	}

	public final boolean tienePlanta() {
		boolean tieneInfo = false;
		if (null != this.getPlanta()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}

	public final void setPlanta(Integer planta) {
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


	public final Integer getCodigoPostal() {
		return codigoPostal;
	}

	public final boolean tieneCodigoPostal() {
		boolean tieneInfo = false;
		if (null != this.getCodigoPostal()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}

	public final void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public final boolean tieneMunicipio() {
		boolean tieneInfo = false;
		if (Constantes.ELEMENTO_NO_SELECCIONADO < Integer.valueOf(this.getIdMunicipio())) {
			tieneInfo = true;
		}
		return tieneInfo;
	}


	public final boolean tieneProvincia() {
		boolean tieneInfo = false;
		if (Constantes.ELEMENTO_NO_SELECCIONADO < Integer.valueOf(this.getIdProvincia())) {
			tieneInfo = true;
		}
		return tieneInfo;
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
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("CriteriosBusquedaViviendaActionForm.validate()");
    	ActionErrors errors = new ActionErrors();
    	String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
    	
		if ( (!ConstantesBotones.CANCELAR.equals(botonPulsado)) &&
			 (!ConstantesBotones.REALIZAR_ENCUESTA.equals(botonPulsado)) &&
			 (!ConstantesBotones.NUEVA_VIVIENDA.equals(botonPulsado)) ) { 
//			 && (!ConstantesBotones.BUSCAR.equals(botonPulsado)) ) {
            if (!this.tieneProvincia()) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.provincia"));
            } else if (Integer.valueOf(this.getIdProvincia()) > ComboProvincia.MELILLA) {
            	errors.add("errorValidacion", new ActionError("error.provincia.no.valido"));
            }
            

		}        
		
		if (!errors.isEmpty()) {
        	request.setAttribute("elementoProvincia", new ElementoComboProvincia());			
			request.setAttribute("comboMunicipio", new ComboMunicipio());
			request.setAttribute("elementoMunicipio", new ElementoComboMunicipio());
		}
        return errors;
    }
    

}