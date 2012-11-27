/**
 * 
 */
package com.evalquiler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.evalquiler.actionforms.encuesta.PreguntasEncuestaActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;


/**
 * @author cachorro
 *
 */
public class DaoPregunta {
	
	private final static String CONSULTAR_PREGUNTA_POR_ID_ENCUESTA = "";

	
	public static final Collection<PreguntasEncuestaActionForm> consultar(final int idEncuesta) throws ExcepcionEjecutarSentancia {
		Collection<PreguntasEncuestaActionForm> listaPreguntas = null;
		PreguntasEncuestaActionForm pregunta = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(CONSULTAR_PREGUNTA_POR_ID_ENCUESTA);
				if (null != pstmt) {
					pstmt.setInt(1, idEncuesta);
					rs = pstmt.executeQuery() ; 
					listaPreguntas = new ArrayList<PreguntasEncuestaActionForm>();
					while(rs.next()) {
						pregunta = new PreguntasEncuestaActionForm();
						listaPreguntas.add(pregunta);
					}
				} else {
					throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
						 	ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
						 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
						 		"error.global.mesage", 
						 		"No se ha obtenido un preparedStatement en DaoPregunta.consultar.");
				}
			} else {
				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
					 		"error.global.mesage", 
					 		"No se ha obtenido una conexión en DaoPregunta.consultar.");
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_ENCUESTA.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 "error.global.mesage", 
				 "DaoPregunta.consultar\n" + e.getMessage());
		}
		
		ConexionBD.cerrarConexiones(conn, pstmt, rs, "DaoPregunta.consultar");
		return listaPreguntas;
	}
	
	
}
