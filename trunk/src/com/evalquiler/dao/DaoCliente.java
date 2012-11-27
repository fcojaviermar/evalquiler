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

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.comun.bbdd.ConexionBD;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesCodigosExcepciones;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;


/**
 * @author cachorro
 *
 */
public class DaoCliente {
	
	private final static String CONSULTAR_CLIENTE_POR_PK = "SELECT IDCLIENTE, PASSWORD, IDTIPODOCUMENTO, NIFCIF, EMAIL, FECHAALTA " +
														   "FROM CLIENTE WHERE IDCLIENTE = ?";
	private final static String INSERTAR_CLIENTE = "INSERT INTO CLIENTE (IDCLIENTE, PASSWORD, IDTIPODOCUMENTO, NIFCIF, EMAIL, FECHAALTA) " +
												   "VALUES (?, ?, ?, ?, ?, SYSDATE())";
	
	public static final Collection<DatosClienteActionForm> consultarPorPk(final String idCliente) throws ExcepcionEjecutarSentancia {
		Collection<DatosClienteActionForm> listaCliente = null;
		DatosClienteActionForm cliente  = null;
		PreparedStatement 	   pstmt 	= null;
		ResultSet 		  	   rs 		= null;
		Connection conn = ConexionBD.getConnection();
		
		try {
			if (null != conn) {
				System.out.println("Obtenida conexion");
				pstmt = conn.prepareStatement(CONSULTAR_CLIENTE_POR_PK);
				if (null != pstmt) {
					pstmt.setString(1, idCliente);
					rs = pstmt.executeQuery() ; 
					listaCliente = new ArrayList<DatosClienteActionForm>();
					while(rs.next()) {
						cliente = new DatosClienteActionForm();
						cliente.setUser(rs.getString("IDCLIENTE"));
						cliente.setPassword(rs.getString("PASSWORD"));
						cliente.setIdTipoDocumento(rs.getInt("IDTIPODOCUMENTO"));
						cliente.setNifcif(rs.getString("NIFCIF"));
						cliente.setEmail(rs.getString("EMAIL"));
						
						listaCliente.add(cliente);
					}
				} else {
					throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
						 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
						 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
						 		"error.global.mesage", 
						 		"No se ha obtenido un preparedStatement en DaoCliente.consultarPorPk.");
				}
			} else {
				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
					 		"error.global.mesage", 
					 		"No se ha obtenido una conexión en DaoCliente.consultarPorPk.");
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 		"error.global.mesage", "DaoCliente.consultarPorPk\n" + e.getMessage());
		} 

		ConexionBD.cerrarConexiones(conn, pstmt, rs, "DaoCliente.consultarPorPk");
		return listaCliente;
	}
	
	
	public static final int insertar(DatosClienteActionForm cliente) throws ExcepcionEjecutarSentancia {
		PreparedStatement pstmt 	 = null;
		int 			  iResultado = 1;
		Connection conn = ConexionBD.getConnection();

		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(INSERTAR_CLIENTE);

				if (null != pstmt) {
					pstmt.setString(1, cliente.getUser());
					pstmt.setString(2, cliente.getPassword());
					pstmt.setInt(3, cliente.getIdTipoDocumento());
					pstmt.setString(4, cliente.getNifcif());
					pstmt.setString(5, cliente.getEmail());

					iResultado = pstmt.executeUpdate();
					if (0 != iResultado ) { //Si se ha insertado el registro en la bbdd
						conn.commit();
						iResultado = Constantes.RESULTADO_OK;
					} else {
						conn.rollback();
						iResultado = Constantes.RESULTADO_NOOK;
					}
				} else {
					throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
						 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
						 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
						 		"error.global.mesage", 
						 		"No se ha obtenido un preparedStatement en DaoCliente.insertar.");
				}
			} else {
				throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
					 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
					 		ConstantesCodigosExcepciones.CODIGO_ERROR_NO_EJECUCION_SENTENCIA)), 
					 		"error.global.mesage", 
					 		"No se ha obtenido una conexión en DaoCliente.insertar.");
			}
		} catch (SQLException e) {
			throw new ExcepcionEjecutarSentancia(ConstantesCodigosExcepciones.ERROR.concat(
				 	ConstantesCodigosExcepciones.FUNCIONALIDAD_CLIENTE.concat(
				 		ConstantesCodigosExcepciones.CODIGO_SQL_EXCEPTION)), 
				 		"error.global.mesage", "DaoCliente.insertar\n" + e.getMessage());
		} 
		
		ConexionBD.cerrarConexiones(conn, pstmt, "DaoCliente.insertar");
		return iResultado;
	}

}
