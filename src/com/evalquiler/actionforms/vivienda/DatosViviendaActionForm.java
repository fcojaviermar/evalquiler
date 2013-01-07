package com.evalquiler.actionforms.vivienda;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.combo.ComboMunicipio;
import com.evalquiler.combo.ComboProvincia;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.entidad.ElementoComboMunicipio;
import com.evalquiler.entidad.ElementoComboProvincia;
import com.evalquiler.entidad.ElementoComboTipoVia;



public class DatosViviendaActionForm extends DatosBasicosViviendaActionForm  {

	private int idTipoVia		   = 0;
	private String descTipoVia	   = null;
	private String nombreVia	   = null;
	private Integer numeroVia	   = null;
	private String bloque		   = null;
	private Integer portal		   = null;
	private String escalera		   = null;
	private String planta		   = null;
	private String puerta		   = null;
	private Integer codigoPostal   = null;
	private String idMunicipio	   = null;
	private String municipio	   = null;
	private String idProvincia	   = null;
	private String provincia	   = null;
	private int pais			   = 194; //Código ISO de España
	private String nifPropietario  = null;
//	private boolean esElPropietario = false;

	
	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	
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


	public Integer getNumeroVia() {
		return numeroVia;
	}


	public void setNumeroVia(Integer numeroVia) {
		this.numeroVia = numeroVia;
	}


	public String getBloque() {
		return bloque;
	}


	public void setBloque(String bloque) {
		this.bloque = bloque;
	}


	public Integer getPortal() {
		return portal;
	}


	public void setPortal(Integer portal) {
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


	public Integer getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


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


//	public boolean getEsElPropietario() {
//		return esElPropietario;
//	}
//
//
//	public void setEsElPropietario(boolean esElPropietario) {
//		this.esElPropietario = esElPropietario;
//	}

	
	public final boolean tieneNumeroVia() {
		boolean tieneInfo = false;
		if (null != this.getNumeroVia()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}

	public final boolean tienePortal() {
		boolean tieneInfo = false;
		if (null != this.getPortal()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}

	
	public final boolean tieneMunicipio() {
		boolean tieneInfo = false;
		if (0 < Integer.valueOf(this.getIdMunicipio()).intValue()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}


	public final boolean tieneProvincia() {
		boolean tieneInfo = false;
		if (0 < Integer.valueOf(this.getIdProvincia()).intValue()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}
	
	public final boolean tieneCodigoPostal() {
		boolean tieneInfo = false;
		if (null != this.getCodigoPostal()) {
			tieneInfo = true;
		}
		return tieneInfo;
	}
	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosViviendaActionForm.validate()");
    	ActionErrors errors = new ActionErrors();
    	
    	String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
		if ( (!ConstantesBotones.GUARDAR.equals(botonPulsado)) &&
			 (!ConstantesBotones.CANCELAR.equals(botonPulsado)) &&
			 (!ConstantesBotones.CARGAR_MUNICIPIOS.equals(botonPulsado)) ) {
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
    
    		if (!this.tieneNumeroVia() && !this.tienePortal())  {
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
    		} else if (this.getPuerta().length() > Constantes.LONGITUD_MAXIMA_PUERTA) {
    			errors.add("errorValidacion", new ActionError("error.puerta.no.valido"));
    		}
    
            if (!this.tieneCodigoPostal()) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.codigopostal"));
            } else if (this.getCodigoPostal().intValue() > Constantes.MAXIMO_CODIGOPOTAL) {
            	errors.add("errorValidacion", new ActionError("error.codigopostal.no.valido"));
            }
    
            if (!this.tieneMunicipio()) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.municipio"));
//            } else if (this.getIdMunicipio() > Constantes.MAXIMO_CODIGOPOTAL) {
//            	errors.add("errorValidacion", new ActionError("error.municipio.no.valido"));
            } else {
            	ComboMunicipio combo = (ComboMunicipio)request.getSession().getAttribute("comboMunicipio");
            	ElementoComboMunicipio elCombo = combo.getId(this.getIdMunicipio());
            	this.setMunicipio(elCombo.getDescripcion());
            	request.setAttribute("elementoMunicipio", elCombo);
            }
    
            if (!this.tieneProvincia()) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.provincia"));
            } else if (Integer.valueOf(this.getIdProvincia()) > ComboProvincia.MELILLA) {
            	errors.add("errorValidacion", new ActionError("error.provincia.no.valido"));
            } else {
            	ComboProvincia combo = (ComboProvincia)request.getSession().getAttribute("comboProvincia");
            	ElementoComboProvincia elCombo = combo.get(Integer.valueOf(this.getIdProvincia()));
            	this.setProvincia(elCombo.getDescripcion());
            	request.setAttribute("elementoProvincia", new ElementoComboProvincia(this.getIdProvincia(), ""));
            }
    
		}
        
		request.setAttribute("tipoViaSeleccionado", new ElementoComboTipoVia(String.valueOf(this.getIdTipoVia()), ""));
		
		if (!errors.isEmpty()) {
			request.setAttribute("elementoProvincia", new ElementoComboProvincia(this.getIdProvincia(), ""));
			request.setAttribute("comboMunicipio", new ComboMunicipio());
			request.setAttribute("elementoMunicipio", new ElementoComboMunicipio(this.getIdMunicipio(), ""));
		}
		
		return errors;
    }
    
}