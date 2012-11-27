package com.evalquiler.actionforms.informe;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.combo.ComboTipoInforme;
import com.evalquiler.combo.ComboTipoUsuario;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.entidad.ElementoComboTipoInforme;
import com.evalquiler.entidad.ElementoComboTipoUsuario;


public class DatosSolicitudInformeActionForm extends ActionForm {

	private long idSolicitudInforme  = 0;
	private int  idTipoInforme 		 = 0;
	private String descTipoInforme   = null;
	private String fechaAlta		 = null;
	private DatosClienteActionForm  datosCliente  = null;
	private DatosViviendaActionForm datosVivienda = null;
	
	
	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public DatosViviendaActionForm getDatosVivienda() {
		return datosVivienda;
	}

	public void setDatosVivienda(DatosViviendaActionForm datosVivienda) {
		this.datosVivienda = datosVivienda;
	}

	public DatosClienteActionForm getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosClienteActionForm datosCliente) {
		this.datosCliente = datosCliente;
	}

	public long getIdSolicitudInforme() {
		return idSolicitudInforme;
	}

	public void setIdSolicitudInforme(long idSolicitudInforme) {
		this.idSolicitudInforme = idSolicitudInforme;
	}


	public int getIdTipoInforme() {
		return idTipoInforme;
	}

	public void setIdTipoInforme(int idTipoInforme) {
		this.idTipoInforme = idTipoInforme;
	}

	public String getDescTipoInforme() {
		return descTipoInforme;
	}

	public void setDescTipoInforme(String descTipoInforme) {
		this.descTipoInforme = descTipoInforme;
	}

	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosSolicitudInformeActionForm.validate()");
    	
    	ActionErrors errors = new ActionErrors();

    	String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
        if (ConstantesBotones.SOLICITAR_INFORME.equals(botonPulsado)) {
            if (this.getIdTipoInforme() <= Constantes.ELEMENTO_NO_SELECCIONADO) {
            	errors.add("errorValidacion", new ActionError("error.obligatorio.tipo.informe"));
            } else if (this.getIdTipoInforme() > Constantes.MAXIMO_TIPO_INFORME) {
            	errors.add("errorValidacion", new ActionError("error.tipo.informe.no.valido"));
            } else {
            	ComboTipoInforme combo = new ComboTipoInforme();
            	ElementoComboTipoInforme elCombo = combo.get(this.getIdTipoInforme());
            	this.setDescTipoInforme(elCombo.getDescripcion());
            }
        }

    	
        return errors;
    }
    

}