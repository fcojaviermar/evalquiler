package com.evalquiler.actions.encuesta;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.PreguntasEncuestaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.operaciones.OpRespuestasEncuesta;

/**
 * @version 	1.0
 * @author
 */
public class ConfirmarRespuestasEncuestaAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ConfirmarRespuestasEncuestaAction.action()");
		
		ActionMessages errors = new ActionMessages();
		ActionForward forward = new ActionForward(); // return value
		String destino = "OK";
		
		int iNumeroPreguntas = 0;
		try {
			iNumeroPreguntas = Integer.parseInt((String)request.getParameter("NumeroPreguntas"));	
		} catch (NumberFormatException e) {
			
		}
		
		try {
//			fechaInicioEvaluacionAlquiler
//			fechaFinEvaluacionAlquiler
			DatosRealizacionEncuestaActionForm datosRealizacionEncuesta = 
												(DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
			datosRealizacionEncuesta.setFechaInicioEvaluacionAlquiler(((DatosRealizacionEncuestaActionForm)form).getFechaInicioEvaluacionAlquiler());
			datosRealizacionEncuesta.setFechaFinEvaluacionAlquiler(((DatosRealizacionEncuestaActionForm)form).getFechaFinEvaluacionAlquiler());
			
			if (!OpRespuestasEncuesta.hayEncuestasRespondidasEnPeriodo(datosRealizacionEncuesta)) {
				DatosEncuestaActionForm datosEncuesta = datosRealizacionEncuesta.getDatosEncuesta();
				if (null != datosEncuesta) {
					Iterator<PreguntasEncuestaActionForm> oIter = datosEncuesta.getPreguntas().iterator();
					int i=0;
					while ( (oIter.hasNext()) && (i<iNumeroPreguntas) ) {
						PreguntasEncuestaActionForm pregunta = oIter.next();
						pregunta.setIdRespuestaDada(Integer.parseInt((String)request.getParameter("idRespuesta" + i)));
						i = i +1;
					}
	    
					((DatosRealizacionEncuestaActionForm)form).setDatosEncuesta(datosEncuesta);
//	    			request.getSession().setAttribute("datosRealizacionEncuestaActionForm", form);
				} else {
					
				}
			} else {
				destino = "ALREADY_EVAL";
				errors.add("errorValidacion", new ActionMessage("error.periodo.ya.evaluado.para.vivienda"));
			}
		} catch (Exception e) {
		    // Report the error using the appropriate name and ID.
		    errors.add("name", new ActionError("id"));
		}
	
		if (!errors.isEmpty()) {
		    //saveErrors(request, errors);
		    // Forward control to the appropriate 'failure' URI (change name as desired)
		    forward = mapping.findForward(destino);
		} else {
		    // Forward control to the appropriate 'success' URI (change name as desired)
		    forward = mapping.findForward(destino);
		}
	
		// Finish with
		return forward;
    }
}
