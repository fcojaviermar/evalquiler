package com.evalquiler.actions.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.combo.ComboTipoDocumento;
import com.evalquiler.combo.ComboTipoUsuario;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.entidad.ElementoComboTipoDocumento;
import com.evalquiler.entidad.ElementoComboTipoUsuario;

/**
 * @version 	1.0
 * @author
 */
public class ConfirmarDatosUsuarioAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ConfirmarDatosUsuarioAction.action()");
		String comandoDestino = ConstantesComandos.EMPTY;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

		try {
			ComboTipoDocumento combo1 = (ComboTipoDocumento)request.getSession().getAttribute("tipoDocumento");
        	ElementoComboTipoDocumento elCombo1 = combo1.get(((DatosUsuarioActionForm)form).getIdTipoDocumento());
        	((DatosUsuarioActionForm)form).setDescTipoDocumento(elCombo1.getDescripcion());

			ComboTipoUsuario combo2 = (ComboTipoUsuario)request.getSession().getAttribute("tipoUsuario");
        	ElementoComboTipoUsuario elCombo2 = combo2.get(((DatosUsuarioActionForm)form).getIdTipoUsuario());
        	((DatosUsuarioActionForm)form).setDescTipoUsuario(elCombo2.getDescripcion());

        	request.getSession().setAttribute("datosUsuarioActionForm", (DatosUsuarioActionForm)form);			
			comandoDestino = ConstantesComandos.OK;
		} catch (Exception e) {
			comandoDestino = ConstantesComandos.ERROR;
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
		}
	
		// If a message is required, save the specified key(s)
		// into the request for use by the <struts:errors> tag.
	
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {
		}
	
		forward = mapping.findForward(comandoDestino);
		return forward;
    }
}
