package com.evalquiler.actionforms.vivienda;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesBotones;



public class DatosViviendaActionForm extends DatosBasicosViviendaActionForm  {

	private int idTipoVia		   = 0;
	private String descTipoVia		   = null;
	private String nombreVia	   = null;
	private int numeroVia	  	   = 0;
	private String bloque		   = null;
	private int portal			   = 0;
	private String escalera		   = null;
	private String planta		   = null;
	private String puerta		   = null;
	private int codigoPostal	   = 0;
	private int municipio		   = 0;
	private int provincia		   = 0;
	private int pais			   = 0;
	private String nifPropietario  = null;
	private boolean esElPropietario = false;

	
	public int getIdTipoVia() {
		return idTipoVia;
	}


	public void setIdTipoVia(int idTipoVia) {
		this.idTipoVia = idTipoVia;
	}

	
	public String getDescTipoVia() {
		return descTipoVia;
	}


	public void setDescTipoVia(String descTipoVia) {
		this.descTipoVia = descTipoVia;
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


	public String getPlanta() {
		return planta;
	}


	public void setPlanta(String planta) {
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


	public boolean getEsElPropietario() {
		return esElPropietario;
	}


	public void setEsElPropietario(boolean esElPropietario) {
		this.esElPropietario = esElPropietario;
	}

	
	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosUsuarioActionForm.validate()");
    	ActionErrors errors = new ActionErrors();
    	
		String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
		if ( (!ConstantesBotones.GUARDAR.equals(botonPulsado)) &&
			 (!ConstantesBotones.CANCELAR.equals(botonPulsado)) ) {
            if (this.getIdTipoVia() <= Constantes.ELEMENTO_NO_SELECCIONADO) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.tipovia"));
            } else if (this.getIdTipoVia() > Constantes.MAXIMO_TIPO_VIA) {
            	errors.add("errorValidacion", new ActionError("error.tipovia.no.valido"));
            }
            
    		if ( (null == this.getNombreVia()) || ("".equals(this.getNombreVia())) ) {
    			errors.add("errorValidacion", new ActionError("error.obligatorio.nombrevia"));
    		} else if (this.getNombreVia().length() > Constantes.LONGITUD_MAXIMA_NOMBREVIA) {
    			errors.add("errorValidacion", new ActionError("error.nombrevia.no.valido"));
    		}
    
    		if ( (null != this.getBloque()) && (!"".equals(this.getBloque())) ) {
    			if (this.getBloque().length() > Constantes.LONGITUD_MAXIMA_BLOQUE) {
    				errors.add("errorValidacion", new ActionError("error.bloque.no.valido"));
    			}
    		}
    
    		if ( (this.getNumeroVia() < Constantes.SIN_NUMERICO_EN_VIA) && 
    			 (this.getPortal() < Constantes.SIN_NUMERICO_EN_VIA) ) {
    			errors.add("errorValidacion", new ActionError("error.obligatorio.numerovia.o.portal"));
    		} else {
    			if (this.getNumeroVia() < Constantes.SIN_NUMERICO_EN_VIA) {
    			    if (this.getPortal() < Constantes.SIN_NUMERICO_EN_VIA) {
    		        	errors.add("errorValidacion", new ActionError("error.obligatorio.portal"));
    		        } else if (this.getPortal() > Constantes.MAXIMO_PORTAL) {
    		        	errors.add("errorValidacion", new ActionError("error.portal.no.valido"));
    		        }
    			} else if (this.getPortal() < Constantes.SIN_NUMERICO_EN_VIA) {
    		        if (this.getNumeroVia() < Constantes.SIN_NUMERICO_EN_VIA) {
    		        	errors.add("errorValidacion", new ActionError("error.obligatorio.numerovia"));
    		        } else if (this.getNumeroVia() > Constantes.MAXIMO_NUMERO_VIA) {
    		        	errors.add("errorValidacion", new ActionError("error.numerovia.no.valido"));
    		        }
    			}			
    		}
    		
    		if ( (null != this.getEscalera()) && (!"".equals(this.getEscalera())) ) {
    			if (this.getEscalera().length() > Constantes.LONGITUD_MAXIMA_ESCALERA) {
    				errors.add("errorValidacion", new ActionError("error.escalera.no.valido"));
    			}
    		}
    
    		if ( (null == this.getPlanta()) || ("".equals(this.getPlanta())) ) {
    			errors.add("errorValidacion", new ActionError("error.obligatorio.planta"));
    		} else if (this.getPlanta().length() > Constantes.LONGITUD_MAXIMA_PLANTA) {
    			errors.add("errorValidacion", new ActionError("error.planta.no.valido"));
    		}
    
    		if ( (null == this.getPuerta()) || ("".equals(this.getPuerta())) ) {
    			errors.add("errorValidacion", new ActionError("error.obligatorio.puerta"));
    		} else if (this.getPlanta().length() > Constantes.LONGITUD_MAXIMA_PUERTA) {
    			errors.add("errorValidacion", new ActionError("error.puerta.no.valido"));
    		}
    
            if (this.getCodigoPostal() < Constantes.SIN_NUMERICO_EN_VIA) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.codigopostal"));
            } else if (this.getCodigoPostal() > Constantes.MAXIMO_CODIGOPOTAL) {
            	errors.add("errorValidacion", new ActionError("error.codigopostal.no.valido"));
            }
    
            if (this.getMunicipio() < Constantes.ELEMENTO_NO_SELECCIONADO) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.municipio"));
            } else if (this.getMunicipio() > Constantes.MAXIMO_CODIGOPOTAL) {
            	errors.add("errorValidacion", new ActionError("error.municipio.no.valido"));
            }
    
            if (this.getProvincia() <= Constantes.ELEMENTO_NO_SELECCIONADO) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.provincia"));
            } else if (this.getProvincia() > Constantes.MAXIMO_CODIGOPOTAL) {
            	errors.add("errorValidacion", new ActionError("error.provincia.no.valido"));
            }
    
            if (this.getPais() <= Constantes.ELEMENTO_NO_SELECCIONADO) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.pais"));
            } else if (this.getPais() > Constantes.MAXIMO_PAIS) {
            	errors.add("errorValidacion", new ActionError("error.pais.no.valido"));
            }
    
//            if (this.getEsElPropietario()) {
//        		if ( (null == this.getNifPropietario()) || ("".equals(this.getNifPropietario())) ) {
//        			errors.add("errorValidacion", new ActionError("error.obligatorio.nifpropietario"));
//        		} else if (Validaciones.nifValido(this.getNifPropietario())) {
//        			errors.add("errorValidacion", new ActionError("error.nifpropietario.no.valido"));
//    //    			errors.add("errorValidacion", new ActionError("error.CIFpropietario.no.valido"));
//    //    			errors.add("errorValidacion", new ActionError("error.NIEpropietario.no.valido"));
//        		}
//            }
		}
        
		return errors;
    }
    
}