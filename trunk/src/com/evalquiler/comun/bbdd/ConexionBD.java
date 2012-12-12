/**
 * 
 */
package com.evalquiler.comun.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;

/**
 * @author cachorro
 *
 */
public class ConexionBD {
	
	private static DataSource dataSource = null;

	public static final Connection getConnection() throws ExcepcionComun {
		Context initContext = null;
		Connection conn = null;
		try {
			initContext = new InitialContext();
			dataSource = (DataSource)initContext.lookup("java:comp/env/jdbc/evalquiler");
						
			conn = dataSource.getConnection();
			if (null != conn) {
				conn.setAutoCommit(false);
			}
		} catch (NamingException e) {
			throw new ExcepcionComun(ConstantesCodigosExcepciones.FUNCIONALIDAD_GENERAL.concat(
			 											ConstantesCodigosExcepciones.CODIGO_EXCEPTION), 
			 						"error.global.mesage", 
			 						"No se ha obtenido un origen de datos v�lido. Revise la configuraci�n del servidor.");
		} catch (SQLException e) {
			throw new ExcepcionComun(ConstantesCodigosExcepciones.FUNCIONALIDAD_GENERAL.concat(
						ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION), 
						"error.global.mesage", 
						"No se ha obtenido un conexi�n. Revise la configuraci�n del servidor y si existe la base de datos.");			
		}
		
		return conn;

	}

	public static final void cerrarConexiones(Connection conn, PreparedStatement pstmt, ResultSet rs, final String lugarProcedencia) throws ExcepcionEjecutarSentancia {
		try {
			if (null != rs) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 		"error.global.mesage", "Cerrando ResultSet de " + lugarProcedencia + "\n" + e.getMessage());
		}
		try {
			if (null != pstmt) {
				pstmt.close() ;
			}
		} catch(final SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 		"error.global.mesage", "Cerrando PreparedStatement " + lugarProcedencia + "\n" + e.getMessage());
		}
			
		try {
			if (null != conn) {
				conn.close() ;
			}
		} catch(final SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 		"error.global.mesage", "Cerrando Connection " + lugarProcedencia + "\n" + e.getMessage());
		}			
	}

	public static final void cerrarConexiones(Connection conn, PreparedStatement pstmt, final String lugarProcedencia) throws ExcepcionEjecutarSentancia {
		try {
			if (null != pstmt) {
				pstmt.close() ;
			}
		} catch(final SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 		"error.global.mesage", "Cerrando PreparedStatement " + lugarProcedencia + "\n" + e.getMessage());
		}
			
		try {
			if (null != conn) {
				conn.close() ;
			}
		} catch(final SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 		"error.global.mesage", "Cerrando Connection " + lugarProcedencia + "\n" + e.getMessage());
		}			
	}
	
	
}
