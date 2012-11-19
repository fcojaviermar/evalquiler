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
import java.util.Iterator;

import org.apache.struts.action.ActionForm;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.PreguntasEncuestaActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;
import com.evalquiler.comun.utilidades.UtilidadesFechas;


/**
 * @author cachorro
 *
 */
public class DaoRespuestasEncuesta {
	
	public static final int SENTENCIA_CONSULTAR_ENCUESTAS_RESPONDIDAS 			 = 1;
	public static final int SENTENCIA_CONSULTAR_PERIODO_EVALUACION_SIN_ENCUESTAS = 2;
	

	private final static String CONSULTAR_PERIODO_EVALUACION_SIN_ENCUESTAS = "SELECT DISTINCT(IDENCUESTA) " +
																			 "FROM RESPUESTAS_ENCUESTA " +
																			 "WHERE IDUSUARIO = ? AND IDENCUESTA = ? AND IDVIVIENDA = ? " +
																			 "AND FECHA_INICIO < ? AND FECHA_FIN > ?";
	
//	SELECT IDENCUESTA, FECHA_INICIO, FECHA_FIN  
//	FROM evalquiler.RESPUESTAS_ENCUESTA 
//	WHERE IDUSUARIO = 'cachorro' AND IDENCUESTA = 1 AND IDVIVIENDA = 2
//	AND FECHA_INICIO >= DATE_FORMAT('2010-12-12',GET_FORMAT(DATE,'USA'))
//	AND FECHA_FIN <= DATE_FORMAT('2012-12-12',GET_FORMAT(DATE,'USA'));	
	
	
	private final static String CONSULTAR_ENCUESTAS_RESPONDIDAS = "SELECT DISTINCT(A.IDENCUESTA), B.DESCRIPCION, A.FECHA_ENCUESTA, C.NOMBREVIA, C.NUMEROVIA, " +
															   "FECHA_INICIO, FECHA_FIN, FECHA_INICIO, FECHA_FIN " +
															   "FROM RESPUESTAS_ENCUESTA A, ENCUESTA B, VIVIENDA C " +
															   "WHERE IDUSUARIO = ? AND A.IDENCUESTA = B.IDENCUESTA AND A.IDVIVIENDA = C.IDVIVIENDA " +
															   "GROUP BY A.IDENCUESTA, C.NOMBREVIA, C.NUMEROVIA, FECHA_INICIO, FECHA_FIN";
	
	
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
						iResultado = 0;
					} else {
						conn.commit();
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

	public static final Collection<DatosRealizacionEncuestaActionForm> consultar(final ActionForm objetoIn, final int tipoConsulta) {
		Collection<DatosRealizacionEncuestaActionForm> listaEncuestasRespondidas = new ArrayList<DatosRealizacionEncuestaActionForm>();
		DatosRealizacionEncuestaActionForm encuestaRespondida = null;		
		DatosEncuestaActionForm datosEncuesta = null;
		DatosViviendaActionForm datosVivienda = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		Connection 		  conn  = ConexionBD.getConnection();
		try {
			if (null != conn) {
				if (tipoConsulta == SENTENCIA_CONSULTAR_ENCUESTAS_RESPONDIDAS) {
    				pstmt = conn.prepareStatement(CONSULTAR_ENCUESTAS_RESPONDIDAS);
    				if (null != pstmt) {
    					pstmt.setString(1, ((DatosUsuarioActionForm)objetoIn).getUser());
    					rs = pstmt.executeQuery() ;
    					
    					while(rs.next()) {
    						encuestaRespondida = new DatosRealizacionEncuestaActionForm();
    						encuestaRespondida.setFechaRealizacion(
    													UtilidadesFechas.getStringFromDate(rs.getDate("FECHA_ENCUESTA")));
    						encuestaRespondida.setFechaInicioEvaluacionAlquiler(
    													UtilidadesFechas.getStringFromDate(rs.getDate("FECHA_INICIO")));
    						encuestaRespondida.setFechaFinEvaluacionAlquiler(
    													UtilidadesFechas.getStringFromDate(rs.getDate("FECHA_FIN")));
    						datosEncuesta = new DatosEncuestaActionForm();
    						datosEncuesta.setTitulo(rs.getString("DESCRIPCION"));
    						datosVivienda = new DatosViviendaActionForm();
    						datosVivienda.setNombreVia(rs.getString("NOMBREVIA"));
    						datosVivienda.setNumeroVia(rs.getInt("NUMEROVIA"));
    						
    						encuestaRespondida.setDatosEncuesta(datosEncuesta);
    						encuestaRespondida.setDatosVivienda(datosVivienda);
    						listaEncuestasRespondidas.add(encuestaRespondida);
    					}
    				} else {
    					System.out.println("No se ha podido obtener un pstmt valido.") ;
    				}
				} else if (tipoConsulta == SENTENCIA_CONSULTAR_PERIODO_EVALUACION_SIN_ENCUESTAS) {
    				pstmt = conn.prepareStatement(CONSULTAR_PERIODO_EVALUACION_SIN_ENCUESTAS);
    				if (null != pstmt) {
    					pstmt.setString(1, ((DatosRealizacionEncuestaActionForm)objetoIn).getDatosUsuario().getUser());
    					pstmt.setInt(2, ((DatosRealizacionEncuestaActionForm)objetoIn).getDatosEncuesta().getIdEncuesta());
    					pstmt.setLong(3, ((DatosRealizacionEncuestaActionForm)objetoIn).getDatosVivienda().getIdVivienda());
    					pstmt.setDate(4, UtilidadesFechas.getDateForSql(
    												((DatosRealizacionEncuestaActionForm)objetoIn).getFechaFinEvaluacionAlquiler()));
    					pstmt.setDate(5, UtilidadesFechas.getDateForSql(
    												((DatosRealizacionEncuestaActionForm)objetoIn).getFechaInicioEvaluacionAlquiler()));
    					rs = pstmt.executeQuery() ;
    					while(rs.next()) {
    						encuestaRespondida = new DatosRealizacionEncuestaActionForm();
    						datosEncuesta = new DatosEncuestaActionForm();
    						datosEncuesta.setIdEncuesta(rs.getInt("IDENCUESTA"));
    						encuestaRespondida.setDatosEncuesta(datosEncuesta);
    						listaEncuestasRespondidas.add(encuestaRespondida);    						
    					}
    				} else {
    					//pstm nulo
    				}
    			} else {
    				//Tipo de consulta no v�lido.
    			}
			} else {
				//No se ha obtenido una conexi�n
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
			
			return listaEncuestasRespondidas;
		}
	}
	
}
