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
import com.evalquiler.comun.bbdd.ConexionBD;


/**
 * @author cachorro
 *
 */
public class DaoCliente {
	
	private final static String CONSULTAR_CLIENTE_POR_PK = "SELECT IDCLIENTE, PASSWORD FROM CLIENTE WHERE IDCLIENTE = ?";
	private final static String INSERTAR_CLIENTE = "INSERT INTO CLIENTE (IDCLIENTE, PASSWORD, TIPODOCUMENTO, NIFCIF, EMAIL, FECHAALTA) " +
												   "VALUES (?, ?, ?, ?, ?, SYSDATE())";
	
	public static final ArrayList<DatosInicioSesionActionForm> consutarPorPk(final String idCliente) {
		ArrayList<DatosInicioSesionActionForm> listaCliente = new ArrayList<DatosInicioSesionActionForm>();
		DatosInicioSesionActionForm cliente = null;
		
		PreparedStatement pstmt = null;
		ResultSet 		  rs 	= null;
		
		Connection conn = ConexionBD.getConnection();
		try {
			if (null != conn) {
				System.out.println("Obtenida conexion");
				pstmt = conn.prepareStatement(CONSULTAR_CLIENTE_POR_PK);
				if (null != pstmt) {
					pstmt.setString(1, idCliente);
					rs = pstmt.executeQuery() ; 
					while(rs.next()) {
						cliente = new DatosInicioSesionActionForm();
						cliente.setUser(rs.getString("IDCLIENTE"));
						cliente.setPassword(rs.getString("PASSWORD"));
						listaCliente.add(cliente);
					}

					System.out.println("Datos obtenidos");
					System.out.println("Usuario: " + cliente.getUser());
					System.out.println("Psw: " + cliente.getPassword());
				} else {
					System.out.println("No se ha podido obtener un pstmt valido.") ;
				}
			} else {
				listaCliente = null;
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
			
			return listaCliente;
		}
	}
	
	
	public static final int insertar(DatosClienteActionForm cliente) {
		PreparedStatement pstmt 	 = null;
		int 			  iResultado = 1;
		Connection conn = ConexionBD.getConnection();
		try {		
			if (null != conn) {
				pstmt = conn.prepareStatement(INSERTAR_CLIENTE);

				if (null != cliente) {
					pstmt.setString(1, cliente.getUser());
					pstmt.setString(2, cliente.getPassword());
					pstmt.setString(3, cliente.getId());
					pstmt.setString(4, cliente.getNifcif());
					pstmt.setString(5, cliente.getEmail());

					iResultado = pstmt.executeUpdate();

					if (0 != iResultado ) { //Si se ha insertado el registro en la bbdd
						System.out.println("Se ha insertado el cliente.");
						conn.commit();
						iResultado = 0;
					} else {
						System.out.println("No se ha insertado el cliente.");
						iResultado = 1;
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
