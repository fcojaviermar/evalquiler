/**
 * 
 */
package com.evalquiler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.PreguntasEncuestaActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;
import com.evalquiler.comun.utilidades.UtilidadesFechas;


/**
 * @author cachorro
 *
 */
public class DaoRespuestasEncuesta {
	
	public static final int SENTENCIA_CONSULTAR_ENCUESTAS_RESPONDIDAS = 1;
	
	private final static String CONSULTAR_ENCUESTAS_RESPONDIDAS = "SELECT DISTINCT(A.IDENCUESTA), B.DESCRIPCION, A.FECHA_ENCUESTA, C.NOMBREVIA, C.NUMEROVIA, " +
															   "FECHA_INICIO, FECHA_FIN " +
															   "FROM RESPUESTAS_ENCUESTA A, ENCUESTA B, VIVIENDA C " +
															   "WHERE IDUSUARIO = ? AND A.IDENCUESTA = B.IDENCUESTA AND A.IDVIVIENDA = C.IDVIVIENDA";
	
	
	private final static String INSERTAR_RESPUESTAS_ENCUESTA = "INSERT INTO RESPUESTAS_ENCUESTA " +
															    "(IDENCUESTA, IDPREGUNTA, IDRESPUESTADADA, IDUSUARIO, FECHA_INICIO, FECHA_FIN, FECHA_ENCUESTA, " +
															    "IDTIPOUSUARIO, IDVIVIENDA) " +
															    "VALUES (?, ?, ?, ?, ?, ?, SYSDATE(), ?, ?)";

	
	public static final int insertar(DatosRealizacionEncuestaActionForm encuestaRealizada) {
		PreparedStatement pstmt 	 = null;
		int 			  iResultado = 1;
		Connection conn = ConexionBD.getConnection();
		try {		
			if (null != conn) {
				if (null != encuestaRealizada) {
					boolean error = false;
					int i=0;
					Iterator<PreguntasEncuestaActionForm> iterPreguntas = encuestaRealizada.getDatosEncuesta().getPreguntas().iterator(); 
					while (!error && (iterPreguntas.hasNext())) {
						pstmt = conn.prepareStatement(INSERTAR_RESPUESTAS_ENCUESTA);	
						if (null != pstmt) {
							PreguntasEncuestaActionForm pregunta = iterPreguntas.next();
							
							pstmt.setInt(1, encuestaRealizada.getDatosEncuesta().getIdEncuesta());
							pstmt.setInt(2, pregunta.getIdPregunta());
							pstmt.setInt(3, pregunta.getIdRespuestaDada());
							pstmt.setString(4, encuestaRealizada.getDatosUsuario().getUser());
							pstmt.setDate(5, UtilidadesFechas.getDateForSql(encuestaRealizada.getFechaInicioEvaluacionAlquiler()));
							pstmt.setDate(6, UtilidadesFechas.getDateForSql(encuestaRealizada.getFechaFinEvaluacionAlquiler()));
							pstmt.setInt(7, encuestaRealizada.getDatosEncuesta().getIdTipoUsuario());
							pstmt.setLong(8, encuestaRealizada.getDatosVivienda().getIdVivienda());
							
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
