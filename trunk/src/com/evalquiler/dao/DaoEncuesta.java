/**
 * 
 */
package com.evalquiler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;


/**
 * @author cachorro
 *
 */
public class DaoEncuesta {
	
	private final static String CONSULTAR_ENCUESTA_POR_PK = "";
	

	public static final ArrayList<DatosEncuestaActionForm> consutarPorPk(final String idVivienda) {
		ArrayList<DatosEncuestaActionForm> datosEncuesta = new ArrayList<DatosEncuestaActionForm>();
		DatosEncuestaActionForm encuesta = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(CONSULTAR_ENCUESTA_POR_PK);
				if (null != pstmt) {
					pstmt.setString(1, idVivienda);
					rs = pstmt.executeQuery() ; 
					while(rs.next()) {
						cliente = new DatosInicioSesionActionForm();
						cliente.setUser(rs.getString("IDCLIENTE"));
					}

					System.out.println("Datos obtenidos");
					System.out.println("Usuario: " + cliente.getUser());
					System.out.println("Psw: " + cliente.getPassword());
				} else {
					System.out.println("No se ha podido obtener un pstmt valido.") ;
				}
			} else {
				datosEncuesta = null;
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
			
			return datosEncuesta;
		}
	}
	
	
}
