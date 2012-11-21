package com.evalquiler.actions.vivienda;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.operaciones.OpVivienda;

/**
 * @version 	1.0
 * @author
 */
public class RealizarBusquedaViviendaAction extends ActionBase {
	
    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ResultadosBusquedaViviendaAction.action()");
		String comandoDestino = ConstantesComandos.EXIT;
		ActionMessages errors = new ActionMessages();
		ActionForward forward = new ActionForward(); // return value
		Collection<DatosViviendaActionForm> listaViviendas = null;
		
		try {
		    // Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			listaViviendas = OpVivienda.consultar(form);
			if (hayVivienda(listaViviendas)) {
				comandoDestino = ConstantesComandos.MORE_THAN_ONE_RESULT;
			} else {
				comandoDestino = ConstantesComandos.NO_RESULT;
				errors.add("errorValidacion", new ActionMessage("msg.no.viviendas.criterios.introducidos"));
			}
			
			request.setAttribute("datosViviendaActionForm", listaViviendas);
		} catch (Exception e) {
		    // Report the error using the appropriate name and ID.
			comandoDestino = ConstantesComandos.ERROR;
		    errors.add("name", new ActionMessage("id"));
		}
	
		forward = mapping.findForward(comandoDestino);	
//		if (!errors.isEmpty()) {
//		    //saveErrors(request, errors);
//		    // Forward control to the appropriate 'failure' URI (change name as desired)
//		    forward = mapping.findForward(comandoDestino);
//		} else {
//		    // Forward control to the appropriate 'success' URI (change name as desired)
//		    forward = mapping.findForward(comandoDestino);
//		}
	
		// Finish with
		return forward;
    }
    
    
    private final boolean hayVivienda(final Collection<DatosViviendaActionForm> listaViviendas) {
    	boolean hayViviendas = false;
    	if (listaViviendas.size() > Constantes.SIN_REGISTROS) {
    		hayViviendas = true;
    	}
    	
    	return hayViviendas;
    }
    
    
}
