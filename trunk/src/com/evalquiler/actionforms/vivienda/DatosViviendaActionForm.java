package com.evalquiler.actionforms.vivienda;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;


public class DatosViviendaActionForm extends DatosBasicosViviendaActionForm  {

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
	private String esElPropietario = null;
	
	public int getIdTipoVia() {
		return idTipoVia;
	}


	public void setIdTipoVia(int idTipoVia) {
		this.idTipoVia = idTipoVia;
	}

	
	public String getNombreVia() {
		return nombreVia;
	}


	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}


	public int getNumeroVia() {
		return numeroVia;
	}


	public void setNumeroVia(int numeroVia) {
		this.numeroVia = numeroVia;
	}


	public String getBloque() {
		return bloque;
	}


	public void setBloque(String bloque) {
		this.bloque = bloque;
	}


	public int getPortal() {
		return portal;
	}


	public void setPortal(int portal) {
		this.portal = portal;
	}


	public String getEscalera() {
		return escalera;
	}


	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}


	public int getPlanta() {
		return planta;
	}


	public void setPlanta(int planta) {
		this.planta = planta;
	}


	public String getPuerta() {
		return puerta;
	}


	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}


	public int getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public int getMunicipio() {
		return municipio;
	}


	public void setMunicipio(int municipio) {
		this.municipio = municipio;
	}


	public int getProvincia() {
		return provincia;
	}


	public void setProvincia(int provincia) {
		this.provincia = provincia;
	}


	public int getPais() {
		return pais;
	}


	public void setPais(int pais) {
		this.pais = pais;
	}


	public String getNifPropietario() {
		return nifPropietario;
	}


	public void setNifPropietario(String nifPropietario) {
		this.nifPropietario = nifPropietario;
	}


	public String getEsElPropietario() {
		return esElPropietario;
	}


	public void setEsElPropietario(String esElPropietario) {
		this.esElPropietario = esElPropietario;
	}

	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosUsuarioActionForm.validate()");
    	ActionErrors errors = null;
    	
    	errors = new ActionErrors();
//        if ( (null == this.getTipoVia()) ||  ("".equals(this.getTipoVia()))) {
//        	errors.add("errorValidacion", new ActionMessage("error.obligatorio.tipovia"));
//        } 
        
        return errors;
    }
    

}