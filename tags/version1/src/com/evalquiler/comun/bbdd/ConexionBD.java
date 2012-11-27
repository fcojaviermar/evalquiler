/**
 * 
 */
package com.evalquiler.comun.bbdd;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author cachorro
 *
 */
public class ConexionBD {
	
	private static DataSource dataSource = null;

	public static final Connection getConnection() {
		Context initContext = null;
		Connection conn = null;
		try {
			initContext = new InitialContext();
			dataSource = (DataSource)initContext.lookup("java:comp/env/jdbc/evalquiler");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			conn = dataSource.getConnection();
			if (null != conn) {
				conn.setAutoCommit(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return conn;
		}
	}

}
