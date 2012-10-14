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


/**
 * @author cachorro
 *
 */
public class DaoPregunta {
	
	private final static String CONSULTAR_PREGUNTA_POR_PK		   = "";	
	private final static String CONSULTAR_PREGUNTA_POR_ID_ENCUESTA = "";

	
	public static final Collection<PreguntasEncuestaActionForm> consultar(final int idEncuesta) {
		Collection<PreguntasEncuestaActionForm> listaPreguntas = new ArrayList<PreguntasEncuestaActionForm>();
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
					while(rs.next()) {
						pregunta = new PreguntasEncuestaActionForm();
						
						listaPreguntas.add(pregunta);
					}
				} else {
					System.out.println("No se ha podido obtener un pstmt valido.") ;
				}
			} else {
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage()) ;
		} catch (Exception e) {
			System.out.println(e.getMessage()) ;
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("Se ha producido un error cerrando rs: ".concat(e.getMessage())) ;
			}
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
			
			return listaPreguntas;
		}
	}
	
	
}
