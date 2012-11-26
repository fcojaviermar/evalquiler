package com.evalquiler.actions.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.combo.ComboTipoDocumento;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.entidad.ElementoComboTipoDocumento;

/**
 * @version 	1.0
 * @author
 */
public class ConfirmarDatosClienteAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ConfirmarDatosClienteAction.action()");
		String comandoDestino = ConstantesComandos.EMPTY;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

	    // Aqui va toda la logica del negocio y todas las llamadas a otras clases.
		ComboTipoDocumento combo1 = (ComboTipoDocumento)request.getSession().getAttribute("tipoDocumento");
    	ElementoComboTipoDocumento elCombo1 = combo1.get(((DatosClienteActionForm)form).getIdTipoDocumento());
    	((DatosClienteActionForm)form).setDescTipoDocumento(elCombo1.getDescripcion());
    	request.getSession().setAttribute("datosClienteActionForm", (DatosClienteActionForm)form);
		comandoDestino = ConstantesComandos.OK;
	
	
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {
		}
	
		forward = mapping.findForward(comandoDestino);
		
		return forward;
    }
}
