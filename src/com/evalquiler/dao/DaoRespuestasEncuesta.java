/**
 * 
 */
package com.evalquiler.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;


/**
 * @author cachorro
 *
 */
public class DaoRespuestasEncuesta {
	
	private final static String INSERTAR_RESPUESTAS_ENCUESTA = "";

	
	public static final int insertar(DatosEncuestaActionForm encuesta) {
		PreparedStatement pstmt 	 = null;
		int 			  iResultado = 1;
		Connection conn = ConexionBD.getConnection();
		try {		
			if (null != conn) {
				if (null != encuesta) {
					boolean error = false;
					int i=0;
					while (!error && (i<encuesta.getPreguntas().size())) {
						pstmt = conn.prepareStatement(INSERTAR_RESPUESTAS_ENCUESTA);	
						if (null != pstmt) {
							pstmt.setInt(1, encuesta.getIdEncuesta());
							pstmt.setInt(2, encuesta.getPreguntas().iterator().next().getIdPregunta());
							pstmt.setInt(3, encuesta.getPreguntas().iterator().next().getIdRespuestaDada());
							pstmt.setDate(4, new Date(encuesta.getFechaInicioEvaluacionAlquiler().getTime()));
							pstmt.setDate(5, new Date(encuesta.getFechaFinEvaluacionAlquiler().getTime()));
							pstmt.setInt(6, encuesta.getIdTipoUsuario());
							pstmt.setString(7, encuesta.getDatosUsuario().getUser());
							pstmt.setLong(8, encuesta.getDatosVivienda().getIdVivienda());
							
							iResultado = pstmt.executeUpdate();
							if (0 != iResultado ) { //Si se ha insertado el registro en la bbdd
								i = i + 1;
								pstmt.close();
							} else {
								error = true;
							}
						} else {
							
						}
					}
					if (error) {
						conn.rollback();
						iResultado = 1;
					} else {
						conn.commit();
						iResultado = 0;
					}
				} else {

				}
			} else {

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage()) ;
		} catch (Exception e) {
			System.out.println(e.getMessage()) ;
		} finally {
			try {
				if (null != pstmt) {
					pstmt.close() ;
				}
			} catch(final SQLException e) {
				System.out.println("Se ha producido un error cerrando pstmt: ".concat(e.getMessage())) ;
			}
			
			try {
				if (null != conn) {
					conn.close() ;
				}
			} catch(final SQLException e) {
				System.out.println("Se ha producido un error cerrando conn: ".concat(e.getMessage())) ;
			}			
			
			return iResultado;
		}
	}	
	
}
