package com.evalquiler.actions.comun;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @version 	1.0
 * @author
 */
public abstract class ActionBase extends Action {

//	private DataSource dataSource = null;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

        //Aqui va el codigo comun que se ejecuta en todos los Actions antes de llamar al Action especifico.


        ActionForward forward = action(mapping, form, request, response);

        //Aqui va el codigo comun que se ejecuta en todos los Actions despues de llamar al Action especifico.

        return forward;

    }

	protected abstract ActionForward action(ActionMapping mapping, ActionForm form,
            								HttpServletRequest request, HttpServletResponse response) throws Exception;


//	public void crearConectionBD_MySQL() {
//		dataSource = getDataSource(requestAux, "gestionmultasMySQL");
//	}
//
//	public void crearConectionBD_PostgreSQL() {
//		dataSource = getDataSource(requestAux, "evalquilePostgreSQL");
//	}

//	public Connection getConnection() {
//		Connection con = null;
//		try {
//			con = dataSource.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return con;
//	}

}
